package com.example.game;

import android.graphics.Point;

import java.util.*;

public class AdjKillingPoints2 {
    Map<Point, ArrayList<Point[]>> adjKillingPoints;
    Point[][] points;
    public AdjKillingPoints2(Map<Point, ArrayList<Point[]>> adjKillingPoints, Point[][] points) {
        this.adjKillingPoints=adjKillingPoints;
        this.points=points;

        addKillingPoints2();
    }

    private void addKillingPoints2() {
        // adjPoint,capturePoint

        Point p1 = points[0][0];
        adjKillingPoints.put(p1, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p1)).add(new Point[]{points[0][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p1)).add(new Point[]{points[1][0],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p1)).add(new Point[]{points[0][2],points[0][1]});
        Objects.requireNonNull(adjKillingPoints.get(p1)).add(new Point[]{points[2][2],points[1][0]});

        Point p2 = points[0][1];
        adjKillingPoints.put(p2, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p2)).add(new Point[]{points[0][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p2)).add(new Point[]{points[0][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p2)).add(new Point[]{points[1][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p2)).add(new Point[]{points[2][2],points[1][1]});

        Point p3 = points[0][2];
        adjKillingPoints.put(p3, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p3)).add(new Point[]{points[0][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p3)).add(new Point[]{points[1][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p3)).add(new Point[]{points[0][0],points[0][1]});
        Objects.requireNonNull(adjKillingPoints.get(p3)).add(new Point[]{points[2][2],points[1][2]});

        Point p4 = points[1][0];
        adjKillingPoints.put(p4, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p4)).add(new Point[]{points[0][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p4)).add(new Point[]{points[1][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p4)).add(new Point[]{points[2][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p4)).add(new Point[]{points[1][2],points[1][1]});
        Objects.requireNonNull(adjKillingPoints.get(p4)).add(new Point[]{points[3][3],points[2][2]});

        Point p5 = points[1][1];
        adjKillingPoints.put(p5, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p5)).add(new Point[]{points[0][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p5)).add(new Point[]{points[1][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p5)).add(new Point[]{points[1][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p5)).add(new Point[]{points[2][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p5)).add(new Point[]{points[3][2],points[2][2]});

        Point p6 = points[1][2];
        adjKillingPoints.put(p6, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p6)).add(new Point[]{points[0][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p6)).add(new Point[]{points[1][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p6)).add(new Point[]{points[2][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p6)).add(new Point[]{points[1][0],points[1][1]});
        Objects.requireNonNull(adjKillingPoints.get(p6)).add(new Point[]{points[3][1],points[2][2]});

        Point p7 = points[2][0];
        adjKillingPoints.put(p7, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p7)).add(new Point[]{points[2][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p7)).add(new Point[]{points[3][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p7)).add(new Point[]{points[3][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p7)).add(new Point[]{points[2][2],points[2][1]});
        Objects.requireNonNull(adjKillingPoints.get(p7)).add(new Point[]{points[4][0],points[3][0]});
        Objects.requireNonNull(adjKillingPoints.get(p7)).add(new Point[]{points[4][2],points[3][1]});

        Point p8 = points[2][1];
        adjKillingPoints.put(p8, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p8)).add(new Point[]{points[2][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p8)).add(new Point[]{points[2][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p8)).add(new Point[]{points[3][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p8)).add(new Point[]{points[2][3],points[2][2]});
        Objects.requireNonNull(adjKillingPoints.get(p8)).add(new Point[]{points[4][1],points[3][1]});

        Point p9 = points[2][2];
        adjKillingPoints.put(p9, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[1][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[1][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[1][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[2][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[2][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[3][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[3][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[3][3],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[0][0],points[1][0]});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[0][1],points[1][1]});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[0][2],points[1][2]});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[2][0],points[2][1]});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[2][4],points[2][3]});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[4][0],points[3][1]});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[4][2],points[3][2]});
        Objects.requireNonNull(adjKillingPoints.get(p9)).add(new Point[]{points[4][4],points[3][3]});

        Point p10 = points[2][3];
        adjKillingPoints.put(p10, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p10)).add(new Point[]{points[2][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p10)).add(new Point[]{points[2][4],null});
        Objects.requireNonNull(adjKillingPoints.get(p10)).add(new Point[]{points[3][3],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p10)).add(new Point[]{points[2][1],points[2][2]});
        Objects.requireNonNull(adjKillingPoints.get(p10)).add(new Point[]{points[4][3],points[3][3]});

        Point p11 = points[2][4];
        adjKillingPoints.put(p11, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p11)).add(new Point[]{points[2][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p11)).add(new Point[]{points[3][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p11)).add(new Point[]{points[3][4],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p11)).add(new Point[]{points[2][2],points[2][3]});
        Objects.requireNonNull(adjKillingPoints.get(p11)).add(new Point[]{points[4][2],points[3][3]});
        Objects.requireNonNull(adjKillingPoints.get(p11)).add(new Point[]{points[4][4],points[3][4]});

        Point p12 = points[3][0];
        adjKillingPoints.put(p12, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p12)).add(new Point[]{points[2][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p12)).add(new Point[]{points[3][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p12)).add(new Point[]{points[4][0],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p12)).add(new Point[]{points[3][2],points[3][1]});
        Objects.requireNonNull(adjKillingPoints.get(p12)).add(new Point[]{points[5][0],points[4][0]});

        Point p13 = points[3][1];
        adjKillingPoints.put(p13, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p13)).add(new Point[]{points[2][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p13)).add(new Point[]{points[2][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p13)).add(new Point[]{points[2][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p13)).add(new Point[]{points[3][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p13)).add(new Point[]{points[3][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p13)).add(new Point[]{points[4][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p13)).add(new Point[]{points[4][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p13)).add(new Point[]{points[4][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p13)).add(new Point[]{points[1][2],points[2][2]});
        Objects.requireNonNull(adjKillingPoints.get(p13)).add(new Point[]{points[3][3],points[3][2]});
        Objects.requireNonNull(adjKillingPoints.get(p13)).add(new Point[]{points[5][1],points[4][1]});
        Objects.requireNonNull(adjKillingPoints.get(p13)).add(new Point[]{points[5][3],points[4][2]});

        Point p14 = points[3][2];
        adjKillingPoints.put(p14, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p14)).add(new Point[]{points[2][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p14)).add(new Point[]{points[3][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p14)).add(new Point[]{points[3][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p14)).add(new Point[]{points[4][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p14)).add(new Point[]{points[1][1],points[2][2]});
        Objects.requireNonNull(adjKillingPoints.get(p14)).add(new Point[]{points[3][0],points[3][1]});
        Objects.requireNonNull(adjKillingPoints.get(p14)).add(new Point[]{points[3][4],points[3][3]});
        Objects.requireNonNull(adjKillingPoints.get(p14)).add(new Point[]{points[5][2],points[4][2]});

        Point p15 = points[3][3];
        adjKillingPoints.put(p15, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p15)).add(new Point[]{points[2][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p15)).add(new Point[]{points[2][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p15)).add(new Point[]{points[2][4],null});
        Objects.requireNonNull(adjKillingPoints.get(p15)).add(new Point[]{points[3][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p15)).add(new Point[]{points[3][4],null});
        Objects.requireNonNull(adjKillingPoints.get(p15)).add(new Point[]{points[4][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p15)).add(new Point[]{points[4][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p15)).add(new Point[]{points[4][4],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p15)).add(new Point[]{points[1][0],points[2][2]});
        Objects.requireNonNull(adjKillingPoints.get(p15)).add(new Point[]{points[3][1],points[3][2]});
        Objects.requireNonNull(adjKillingPoints.get(p15)).add(new Point[]{points[5][1],points[4][2]});
        Objects.requireNonNull(adjKillingPoints.get(p15)).add(new Point[]{points[5][3],points[4][3]});

        Point p16 = points[3][4];
        adjKillingPoints.put(p16, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p16)).add(new Point[]{points[2][4],null});
        Objects.requireNonNull(adjKillingPoints.get(p16)).add(new Point[]{points[3][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p16)).add(new Point[]{points[4][4],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p16)).add(new Point[]{points[3][2],points[3][3]});
        Objects.requireNonNull(adjKillingPoints.get(p16)).add(new Point[]{points[5][4],points[4][4]});

        Point p17 = points[4][0];
        adjKillingPoints.put(p17, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p17)).add(new Point[]{points[3][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p17)).add(new Point[]{points[3][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p17)).add(new Point[]{points[4][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p17)).add(new Point[]{points[5][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p17)).add(new Point[]{points[5][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p17)).add(new Point[]{points[2][0],points[3][0]});
        Objects.requireNonNull(adjKillingPoints.get(p17)).add(new Point[]{points[2][2],points[3][1]});
        Objects.requireNonNull(adjKillingPoints.get(p17)).add(new Point[]{points[4][2],points[4][1]});
        Objects.requireNonNull(adjKillingPoints.get(p17)).add(new Point[]{points[6][0],points[5][0]});
        Objects.requireNonNull(adjKillingPoints.get(p17)).add(new Point[]{points[6][2],points[5][1]});

        Point p18 = points[4][1];
        adjKillingPoints.put(p18, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p18)).add(new Point[]{points[3][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p18)).add(new Point[]{points[4][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p18)).add(new Point[]{points[4][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p18)).add(new Point[]{points[5][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p18)).add(new Point[]{points[2][1],points[3][1]});
        Objects.requireNonNull(adjKillingPoints.get(p18)).add(new Point[]{points[4][3],points[4][2]});
        Objects.requireNonNull(adjKillingPoints.get(p18)).add(new Point[]{points[6][1],points[5][1]});

        Point p19 = points[4][2];
        adjKillingPoints.put(p19, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[3][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[3][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[3][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[4][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[4][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[5][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[5][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[5][3],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[2][0],points[3][1]});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[2][2],points[3][2]});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[2][4],points[3][3]});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[4][0],points[4][1]});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[4][4],points[4][3]});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[6][0],points[5][1]});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[6][2],points[5][2]});
        Objects.requireNonNull(adjKillingPoints.get(p19)).add(new Point[]{points[6][4],points[5][3]});

        Point p20 = points[4][3];
        adjKillingPoints.put(p20, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p20)).add(new Point[]{points[3][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p20)).add(new Point[]{points[4][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p20)).add(new Point[]{points[4][4],null});
        Objects.requireNonNull(adjKillingPoints.get(p20)).add(new Point[]{points[5][3],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p20)).add(new Point[]{points[2][3],points[3][3]});
        Objects.requireNonNull(adjKillingPoints.get(p20)).add(new Point[]{points[4][1],points[4][2]});
        Objects.requireNonNull(adjKillingPoints.get(p20)).add(new Point[]{points[6][3],points[5][3]});

        Point p21 = points[4][4];
        adjKillingPoints.put(p21, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p21)).add(new Point[]{points[3][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p21)).add(new Point[]{points[3][4],null});
        Objects.requireNonNull(adjKillingPoints.get(p21)).add(new Point[]{points[4][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p21)).add(new Point[]{points[5][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p21)).add(new Point[]{points[5][4],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p21)).add(new Point[]{points[2][2],points[3][3]});
        Objects.requireNonNull(adjKillingPoints.get(p21)).add(new Point[]{points[2][4],points[3][4]});
        Objects.requireNonNull(adjKillingPoints.get(p21)).add(new Point[]{points[4][2],points[4][3]});
        Objects.requireNonNull(adjKillingPoints.get(p21)).add(new Point[]{points[6][2],points[5][3]});
        Objects.requireNonNull(adjKillingPoints.get(p21)).add(new Point[]{points[6][4],points[5][4]});

        Point p22 = points[5][0];
        adjKillingPoints.put(p22, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p22)).add(new Point[]{points[4][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p22)).add(new Point[]{points[5][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p22)).add(new Point[]{points[6][0],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p22)).add(new Point[]{points[3][0],points[4][0]});
        Objects.requireNonNull(adjKillingPoints.get(p22)).add(new Point[]{points[5][2],points[5][1]});

        Point p23 = points[5][1];
        adjKillingPoints.put(p23, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p23)).add(new Point[]{points[4][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p23)).add(new Point[]{points[4][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p23)).add(new Point[]{points[4][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p23)).add(new Point[]{points[5][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p23)).add(new Point[]{points[5][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p23)).add(new Point[]{points[6][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p23)).add(new Point[]{points[6][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p23)).add(new Point[]{points[6][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p23)).add(new Point[]{points[3][1],points[4][1]});
        Objects.requireNonNull(adjKillingPoints.get(p23)).add(new Point[]{points[3][3],points[4][2]});
        Objects.requireNonNull(adjKillingPoints.get(p23)).add(new Point[]{points[5][3],points[5][2]});
        Objects.requireNonNull(adjKillingPoints.get(p23)).add(new Point[]{points[7][2],points[6][2]});

        Point p24 = points[5][2];
        adjKillingPoints.put(p24, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p24)).add(new Point[]{points[4][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p24)).add(new Point[]{points[5][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p24)).add(new Point[]{points[5][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p24)).add(new Point[]{points[6][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p24)).add(new Point[]{points[3][2],points[4][2]});
        Objects.requireNonNull(adjKillingPoints.get(p24)).add(new Point[]{points[5][0],points[5][1]});
        Objects.requireNonNull(adjKillingPoints.get(p24)).add(new Point[]{points[5][4],points[5][3]});
        Objects.requireNonNull(adjKillingPoints.get(p24)).add(new Point[]{points[7][1],points[6][2]});

        Point p25 = points[5][3];
        adjKillingPoints.put(p25, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p25)).add(new Point[]{points[4][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p25)).add(new Point[]{points[4][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p25)).add(new Point[]{points[4][4],null});
        Objects.requireNonNull(adjKillingPoints.get(p25)).add(new Point[]{points[5][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p25)).add(new Point[]{points[5][4],null});
        Objects.requireNonNull(adjKillingPoints.get(p25)).add(new Point[]{points[6][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p25)).add(new Point[]{points[6][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p25)).add(new Point[]{points[6][4],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p25)).add(new Point[]{points[3][1],points[4][2]});
        Objects.requireNonNull(adjKillingPoints.get(p25)).add(new Point[]{points[3][3],points[4][3]});
        Objects.requireNonNull(adjKillingPoints.get(p25)).add(new Point[]{points[5][1],points[5][2]});
        Objects.requireNonNull(adjKillingPoints.get(p25)).add(new Point[]{points[7][0],points[6][2]});

        Point p26 = points[5][4];
        adjKillingPoints.put(p26, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p26)).add(new Point[]{points[4][4],null});
        Objects.requireNonNull(adjKillingPoints.get(p26)).add(new Point[]{points[5][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p26)).add(new Point[]{points[6][4],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p26)).add(new Point[]{points[3][4],points[4][4]});
        Objects.requireNonNull(adjKillingPoints.get(p26)).add(new Point[]{points[5][2],points[5][3]});

        Point p27 = points[6][0];
        adjKillingPoints.put(p27, new ArrayList<>());
        Objects.requireNonNull(adjKillingPoints.get(p27)).add(new Point[]{points[5][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p27)).add(new Point[]{points[5][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p27)).add(new Point[]{points[6][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p27)).add(new Point[]{points[4][0],points[5][0]});
        Objects.requireNonNull(adjKillingPoints.get(p27)).add(new Point[]{points[4][2],points[5][1]});
        Objects.requireNonNull(adjKillingPoints.get(p27)).add(new Point[]{points[6][2],points[6][1]});

        Point p28 = points[6][1];
        adjKillingPoints.put(p28, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p28)).add(new Point[]{points[5][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p28)).add(new Point[]{points[6][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p28)).add(new Point[]{points[6][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p28)).add(new Point[]{points[4][1],points[5][1]});
        Objects.requireNonNull(adjKillingPoints.get(p28)).add(new Point[]{points[6][3],points[6][2]});

        Point p29 = points[6][2];
        adjKillingPoints.put(p29, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[5][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[5][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[5][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[6][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[6][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[7][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[7][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[7][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[4][0],points[5][1]});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[4][2],points[5][2]});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[4][4],points[5][3]});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[6][0],points[6][1]});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[6][4],points[6][3]});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[8][0],points[7][0]});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[8][1],points[7][1]});
        Objects.requireNonNull(adjKillingPoints.get(p29)).add(new Point[]{points[8][2],points[7][2]});

        Point p30 = points[6][3];
        adjKillingPoints.put(p30, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p30)).add(new Point[]{points[5][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p30)).add(new Point[]{points[6][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p30)).add(new Point[]{points[6][4],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p30)).add(new Point[]{points[4][3],points[5][3]});
        Objects.requireNonNull(adjKillingPoints.get(p30)).add(new Point[]{points[6][1],points[6][2]});

        Point p31 = points[6][4];
        adjKillingPoints.put(p31, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p31)).add(new Point[]{points[5][3],null});
        Objects.requireNonNull(adjKillingPoints.get(p31)).add(new Point[]{points[5][4],null});
        Objects.requireNonNull(adjKillingPoints.get(p31)).add(new Point[]{points[6][3],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p31)).add(new Point[]{points[4][2],points[5][3]});
        Objects.requireNonNull(adjKillingPoints.get(p31)).add(new Point[]{points[4][4],points[5][4]});
        Objects.requireNonNull(adjKillingPoints.get(p31)).add(new Point[]{points[6][2],points[6][3]});

        Point p32 = points[7][0];
        adjKillingPoints.put(p32, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p32)).add(new Point[]{points[6][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p32)).add(new Point[]{points[7][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p32)).add(new Point[]{points[8][0],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p32)).add(new Point[]{points[5][3],points[6][2]});
        Objects.requireNonNull(adjKillingPoints.get(p32)).add(new Point[]{points[7][2],points[7][1]});

        Point p33 = points[7][1];
        adjKillingPoints.put(p33, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p33)).add(new Point[]{points[6][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p33)).add(new Point[]{points[7][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p33)).add(new Point[]{points[7][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p33)).add(new Point[]{points[8][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p33)).add(new Point[]{points[5][2],points[6][2]});

        Point p34 = points[7][2];
        adjKillingPoints.put(p34, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p34)).add(new Point[]{points[6][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p34)).add(new Point[]{points[7][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p34)).add(new Point[]{points[8][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p34)).add(new Point[]{points[5][1],points[6][2]});
        Objects.requireNonNull(adjKillingPoints.get(p34)).add(new Point[]{points[7][0],points[7][1]});

        Point p35 = points[8][0];
        adjKillingPoints.put(p35, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p35)).add(new Point[]{points[7][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p35)).add(new Point[]{points[8][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p35)).add(new Point[]{points[6][2],points[7][0]});
        Objects.requireNonNull(adjKillingPoints.get(p35)).add(new Point[]{points[8][2],points[8][1]});

        Point p36 = points[8][1];
        adjKillingPoints.put(p36, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p36)).add(new Point[]{points[7][1],null});
        Objects.requireNonNull(adjKillingPoints.get(p36)).add(new Point[]{points[8][0],null});
        Objects.requireNonNull(adjKillingPoints.get(p36)).add(new Point[]{points[8][2],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p36)).add(new Point[]{points[6][2],points[7][1]});

        Point p37 = points[8][2];
        adjKillingPoints.put(p37, new ArrayList<>());
        // adj
        Objects.requireNonNull(adjKillingPoints.get(p37)).add(new Point[]{points[7][2],null});
        Objects.requireNonNull(adjKillingPoints.get(p37)).add(new Point[]{points[8][1],null});
        // kill
        Objects.requireNonNull(adjKillingPoints.get(p37)).add(new Point[]{points[6][2],points[7][2]});
        Objects.requireNonNull(adjKillingPoints.get(p37)).add(new Point[]{points[8][0],points[8][1]});

    }

}
