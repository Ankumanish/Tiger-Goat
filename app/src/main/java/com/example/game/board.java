package com.example.game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class board extends View {

    private boolean isDragging;
    private float stX,stY;
    private final int width;
    private final int height;
    private double rX,rY;
    private final int boardColor;
    private final int dotColor;
    private final Drawable goatImage;
    private final Drawable tigerImage;
    private final Drawable selectedGoatImage;
    private final Drawable selectedTigerImage;
    private final Point[][] points;
    private final ArrayList<Point> goats;
    private final ArrayList<Point> tigers;
    private final Map<Point, ArrayList<Point[]>> adjKillingPoints;

    private boolean isGoatTurn = true;
    private Point selectedTiger = null;
    private Point selectedGoat = null;
    private int goatAliveCount = 7;
    private int killedGoats = 0;
    private int gameCompleted = 0;

    private final Paint paint = new Paint();

    private TextView remaining1;
    private TextView kills1;

    public board(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a=context.getTheme().obtainStyledAttributes(attrs, R.styleable.Board,0,0);

        try{

            // board 1
            points=new Point[][]{
                    { new Point(540, 500) },
                    { new Point(350, 1000), new Point(540, 1000), new Point(730, 1000) },
                    { new Point(220, 1350), new Point(540, 1350), new Point(860, 1350) },
                    { new Point(90, 1700), new Point(540, 1700), new Point(990, 1700) }
            };



            int goatResId = a.getResourceId(R.styleable.Board_goatImage, 0);
            goatImage = ContextCompat.getDrawable(context, goatResId);
            int tigerResId = a.getResourceId(R.styleable.Board_tigerImage, 0);
            tigerImage = ContextCompat.getDrawable(context, tigerResId);
            int selectedGoatImageId = a.getResourceId(R.styleable.Board_selectedGoatImage, 0);
            selectedGoatImage = ContextCompat.getDrawable(context, selectedGoatImageId);
            int selectedTigerImageId = a.getResourceId(R.styleable.Board_selectedTigerImage, 0);
            selectedTigerImage = ContextCompat.getDrawable(context, selectedTigerImageId);

            boardColor=a.getInteger(R.styleable.Board_boardColor,0);
            dotColor=a.getInteger(R.styleable.Board_dotColor,0);


        }
        finally {
            a.recycle();
        }

        MainActivity main=new MainActivity();
        this.width=main.getWidth();
        this.height=main.getHeight();

        goats = new ArrayList<>();
        tigers = new ArrayList<>();
        adjKillingPoints = new HashMap<>();

        reSize();

        addTigerPositions();
        new AdjKillingPoints(adjKillingPoints,points);

    }

    public void setTextViews(TextView remaining, TextView kills) {
        this.remaining1 = remaining;
        this.kills1 = kills;
    }

    private void reSize() {
        // board 1

        this.rX=1.1*width/1080;
        this.rY=1.1*height/2400;

        int difX1=(int)(((double) width /2)-Math.ceil(rX*points[0][0].x));

        for(Point[] row:points){
            for(Point p:row){
                p.x=(int)Math.ceil(rX * p.x)+difX1;
                p.y=(int)Math.ceil(rY * p.y);

            }
        }

    }


    private void addTigerPositions(){

        // board 1
        tigers.add(points[0][0]);
        tigers.add(points[2][1]);

    }

    @Override
    protected void onDraw(@NonNull Canvas canvas){

        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        drawGameBoard(canvas);
        drawPieces(canvas);

        if (selectedTiger != null) {
            drawPieceTiger(canvas);
            drawPieceMovablePoints(canvas,selectedTiger);
        }
        if (selectedGoat != null) {
            drawPieceGoat(canvas);
            drawPieceMovablePoints(canvas,selectedGoat);
        }


    }

    private void drawPieceGoat(Canvas canvas) {
        selectedGoatImage.setBounds(selectedGoat.x-(int)(50*rX),selectedGoat.y-(int)(50*rY), selectedGoat.x+(int)(50*rX),selectedGoat.y+(int)(50*rY));
        selectedGoatImage.draw(canvas);

    }


    private void drawPieceTiger(Canvas canvas) {
        selectedTigerImage.setBounds(selectedTiger.x-(int)(50*rX),selectedTiger.y-(int)(50*rY), selectedTiger.x+(int)(50*rX),selectedTiger.y+(int)(50*rY));
        selectedTigerImage.draw(canvas);

    }

    private void drawPieceMovablePoints(Canvas canvas,Point point) {
        ArrayList<Point[]> ar = adjKillingPoints.get(point);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(15, 15, 250));
        for (int i=0;ar != null && i<ar.size();i++) {
            Point[] p=ar.get(i);
            if(p[1] == null && !goats.contains(p[0]) && !tigers.contains(p[0])){
                canvas.drawOval(p[0].x - 25, p[0].y - 25, p[0].x + 25, p[0].y + 25, paint);
            }
            else if(selectedTiger != null && p[1] != null && goats.contains(p[1]) && !goats.contains(p[0]) && !tigers.contains(p[0])){
                canvas.drawOval(p[0].x - 25, p[0].y - 25, p[0].x + 25, p[0].y + 25, paint);
            }

        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event){

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                stX = event.getX();
                stY = event.getY();
                isDragging = false;
                return true;

            case MotionEvent.ACTION_MOVE:
                float difX1 = Math.abs(event.getX() - stX);
                float difY1 = Math.abs(event.getY() - stY);
                if (difX1 > 10 || difY1 > 10) {
                    isDragging = true;
                }
                return true;

            case MotionEvent.ACTION_UP:
                float difX2 = Math.abs(event.getX() - stX);
                float difY2 = Math.abs(event.getY() - stY);
                if (!isDragging && difX2 <= 10 && difY2 <= 10) {
                    performAction(event);
                }
                return true;
        }

        return false;
    }

    private void performAction(MotionEvent event) {
        Point clickPoint = new Point((int)event.getX(),(int)event.getY());
        Point closestPoint = findClosestPoint(clickPoint);

        if (isGoatTurn && gameCompleted == 0) {
            if (goatAliveCount > 0) {
                if (closestPoint != null && !goats.contains(closestPoint) && !tigers.contains(closestPoint)) {
                    goats.add(closestPoint);
                    goatAliveCount--;
                    isGoatTurn = false;
                    // play sound
                    SoundManager.getInstance(getContext()).playMovementSound();
                }
            }

            else {
                if (selectedGoat == null) {
                    if (closestPoint != null && goats.contains(closestPoint)) {
                        selectedGoat = closestPoint;
                    }
                }

                else {
                    Point targetPoint = closestPoint;
                    if (targetPoint == null || tigers.contains(targetPoint)) {
                        targetPoint = null;
                    } else if (goats.contains(targetPoint)) {
                        selectedGoat = targetPoint;
                        targetPoint = null;
                    }

                    if (targetPoint != null) {
                        Point[] point = findPoint(Objects.requireNonNull(adjKillingPoints.get(selectedGoat)), targetPoint);
                        if (point != null && point[1] == null && !goats.contains(point[0]) && !tigers.contains(point[0])) {
                            goats.remove(selectedGoat);
                            goats.add(targetPoint);
                            selectedGoat = null;
                            isGoatTurn = false;
                            // play sound
                            SoundManager.getInstance(getContext()).playMovementSound();
                        }
                    }
                }
            }
        }

        else if (!isGoatTurn && gameCompleted == 0) {
            if (selectedTiger == null) {
                if (closestPoint != null && tigers.contains(closestPoint)) {
                    selectedTiger = closestPoint;
                }
            }

            else {
                Point targetPoint = closestPoint;
                if (targetPoint == null || goats.contains(targetPoint)) {
                    targetPoint = null;
                } else if (tigers.contains(targetPoint)) {
                    selectedTiger = targetPoint;
                    targetPoint = null;
                }

                if (targetPoint != null) {
                    Point[] point = findPoint(Objects.requireNonNull(adjKillingPoints.get(selectedTiger)), targetPoint);
                    if (point != null && point[1] == null && !goats.contains(point[0]) && !tigers.contains(point[0])) {
                        tigers.remove(selectedTiger);
                        tigers.add(targetPoint);
                        selectedTiger = null;
                        isGoatTurn = true;
                        // play sound
                        SoundManager.getInstance(getContext()).playMovementSound();
                    }

                    else if (point != null && point[1] != null && goats.contains(point[1]) && !goats.contains(point[0]) && !tigers.contains(point[0])) {
                        tigers.remove(selectedTiger);
                        tigers.add(point[0]);
                        goats.remove(point[1]);
                        selectedTiger = null;
                        isGoatTurn = true;
                        killedGoats++;
                        // play sound
                        SoundManager.getInstance(getContext()).playCaptureSound();
                    }
                }
            }

        }

        gameCompleted = isGameOver();

        invalidate();

        checkGameCompletion();

    }

    private void checkGameCompletion() {
        if (gameCompleted != 0) {
            Winning_View winningView = new Winning_View(getContext());
            if(gameCompleted == 2){
                winningView.setWinningText("Tigers "); // Pass the string here
            }
            else if(gameCompleted == 1){
                winningView.setWinningText("Goats "); // Pass the string here
            }
            winningView.show();
        }
    }


    private Point[] findPoint(ArrayList<Point[]> kill, Point targetPoint) {
        for(Point[] p:kill){
            if(p[0].equals(targetPoint)){
                return p;
            }
        }
        return null;
    }

    private Point findClosestPoint(Point clickPoint) {
        for (Point[] point : points) {
            for (Point p : point) {
                float distance = distanceBetween(p,clickPoint);
                if (distance <= 50) {
                    return p;
                }
            }
        }
        // Return closestPoint only if it is within the threshold distance
        return null;
    }

    private float distanceBetween(Point p1,Point p2){
        float dx = p1.x - p2.x;
        float dy = p1.y - p2.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public int isGameOver() {
        // Tigers are win
        if (killedGoats >= 2) {
            return 2;
        }

        // Goats are win
        if (blockedAdjKillingPoints()) {
            return 1;
        }
        return 0;
    }

    private boolean blockedAdjKillingPoints() {
        for(Point point:tigers) {
            ArrayList<Point[]> ar = adjKillingPoints.get(point);

            for (int i = 0; ar != null && i < ar.size(); i++) {
                Point[] p = ar.get(i);

                if (p[1] == null && !goats.contains(p[0]) && !tigers.contains(p[0])) {
                    return false;
                }
                if (p[1] != null && goats.contains(p[1]) && !goats.contains(p[0]) && !tigers.contains(p[0])) {
                    return false;
                }

            }
        }
        return true;
    }


    private void drawPieces(Canvas canvas) {
        for(Point goat:goats){
            goatImage.setBounds(goat.x-(int)(50*rX),goat.y-(int)(50*rY), goat.x+(int)(50*rX),goat.y+(int)(50*rY));
            goatImage.draw(canvas);
        }
        for(Point tiger:tigers){
            tigerImage.setBounds(tiger.x-(int)(50*rX),tiger.y-(int)(50*rY), tiger.x+(int)(50*rX),tiger.y+(int)(50*rY));
            tigerImage.draw(canvas);
        }

    }

    // board 1
    @SuppressLint("SetTextI18n")
    private void drawGameBoard(Canvas canvas){

        remaining1.setText(" " + goatAliveCount);
        kills1.setText(" " + killedGoats);

        paint.setColor(boardColor);
        paint.setStrokeWidth(20);

        // Draw the horizontal lines
        canvas.drawLine(points[1][0].x, points[1][0].y, points[1][2].x, points[1][2].y,paint);
        canvas.drawLine(points[2][0].x, points[2][0].y, points[2][2].x, points[2][2].y,paint);
        canvas.drawLine(points[3][0].x, points[3][0].y, points[3][2].x, points[3][2].y,paint);

        // Draw the vertical lines
        canvas.drawLine(points[0][0].x, points[0][0].y, points[3][1].x, points[3][1].y,paint);

        // Draw the diagonal lines
        canvas.drawLine(points[0][0].x, points[0][0].y, points[3][0].x, points[3][0].y,paint);
        canvas.drawLine(points[0][0].x, points[0][0].y, points[3][2].x, points[3][2].y,paint);

        for (Point[] value : points) {
            for (Point point : value) {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(dotColor);
                if (!goats.contains(point) && !tigers.contains(point)) {
                    canvas.drawOval(point.x - 25, point.y - 25, point.x + 25, point.y + 25, paint);
                }
            }
        }

    }

}