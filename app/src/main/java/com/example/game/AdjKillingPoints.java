package com.example.game;

import android.graphics.Point;

import java.util.*;

public class AdjKillingPoints {
    Map<Point, ArrayList<Point[]>> adjKillingPoints;
    Point[][] points;
    public AdjKillingPoints(Map<Point, ArrayList<Point[]>> adjKillingPoints, Point[][] points) {
        this.adjKillingPoints=adjKillingPoints;
        this.points=points;

        addKillingPoints1();
    }

    private void addKillingPoints1(){
        // adjPoint,capturePoint

        Point p1 = points[0][0];
        adjKillingPoints.put(p1, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p1)).add(new Point[]{points[1][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p1)).add(new Point[]{points[1][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p1)).add(new Point[]{points[1][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p1)).add(new Point[]{points[2][0],points[1][0]});
        Objects.requireNonNull(adjKillingPoints.get(p1)).add(new Point[]{points[2][1],points[1][1]});
        Objects.requireNonNull(adjKillingPoints.get(p1)).add(new Point[]{points[2][2],points[1][2]});

        Point p2 = points[1][0];
        adjKillingPoints.put(p2, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p2)).add(new Point[]{points[0][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p2)).add(new Point[]{points[1][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p2)).add(new Point[]{points[2][0],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p2)).add(new Point[]{points[1][2],points[1][1]});
        Objects.requireNonNull(adjKillingPoints.get(p2)).add(new Point[]{points[3][0],points[2][0]});

        Point p3 = points[1][1];
        adjKillingPoints.put(p3, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p3)).add(new Point[]{points[0][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p3)).add(new Point[]{points[1][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p3)).add(new Point[]{points[1][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p3)).add(new Point[]{points[2][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p3)).add(new Point[]{points[3][1],points[2][1]});

        Point p4 = points[1][2];
        adjKillingPoints.put(p4, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p4)).add(new Point[]{points[0][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p4)).add(new Point[]{points[1][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p4)).add(new Point[]{points[2][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p4)).add(new Point[]{points[1][0],points[1][1]});
        Objects.requireNonNull(adjKillingPoints.get(p4)).add(new Point[]{points[3][2],points[2][2]});

        Point p5 = points[2][0];
        adjKillingPoints.put(p5, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p5)).add(new Point[]{points[1][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p5)).add(new Point[]{points[2][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p5)).add(new Point[]{points[3][0],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p5)).add(new Point[]{points[0][0],points[1][0]});
        Objects.requireNonNull(adjKillingPoints.get(p5)).add(new Point[]{points[2][2],points[2][1]});

        Point p6 = points[2][1];
        adjKillingPoints.put(p6, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p6)).add(new Point[]{points[1][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p6)).add(new Point[]{points[2][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p6)).add(new Point[]{points[2][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p6)).add(new Point[]{points[3][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p6)).add(new Point[]{points[0][0],points[1][1]});

        Point p7 = points[2][2];
        adjKillingPoints.put(p7, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p7)).add(new Point[]{points[1][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p7)).add(new Point[]{points[2][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p7)).add(new Point[]{points[3][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p7)).add(new Point[]{points[0][0],points[1][2]});
        Objects.requireNonNull(adjKillingPoints.get(p7)).add(new Point[]{points[2][0],points[2][1]});

        Point p8 = points[3][0];
        adjKillingPoints.put(p8, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p8)).add(new Point[]{points[2][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p8)).add(new Point[]{points[3][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p8)).add(new Point[]{points[1][0],points[2][0]});
        Objects.requireNonNull(adjKillingPoints.get(p8)).add(new Point[]{points[3][2],points[3][1]});

        Point p9 = points[3][1];
        adjKillingPoints.put(p9, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[2][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[3][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[3][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[1][1],points[2][1]});

        Point p10 = points[3][2];
        adjKillingPoints.put(p10, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p10)).add(new Point[]{points[2][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p10)).add(new Point[]{points[3][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p10)).add(new Point[]{points[1][2],points[2][2]});
        Objects.requireNonNull(adjKillingPoints.get(p10)).add(new Point[]{points[3][0],points[3][1]});
    }

}
