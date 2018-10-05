package kr.dja.advancedJava;

import java.util.Random;

public class Task_1
{
	public static void main(String[] args)
	{
		Point[] randomPoints = getRandomPoints(new Random(), 5, 100);
		double[] distances = getDistances(randomPoints, randomPoints[0]);

		System.out.print("Point\t\t");
		for (int i = 0; i < randomPoints.length; ++i)
		{
			System.out.print(String.format("%d:%s\t", i, randomPoints[i]));
		}
		System.out.println();
		System.out.print("Distance\t");
		for (int i = 0; i < distances.length; ++i)
		{
			System.out.print(String.format("%d:[%.2f]\t\t", i, distances[i]));
		}
		System.out.println();
	}

	public static Point[] getRandomPoints(Random r, int size, int multiple)
	{
		Point[] randomPoints = new Point[size];
		for (int i = 0; i < size; ++i)
		{
			randomPoints[i] = new Point(r.nextDouble() * multiple, r.nextDouble() * multiple);
		}
		return randomPoints;
	}

	public static double[] getDistances(Point[] points, Point target)
	{
		double[] distances = new double[points.length];
		double x, y;
		for (int i = 0; i < points.length; ++i)
		{
			x = Math.pow(target.X - points[i].X, 2);
			y = Math.pow(target.Y - points[i].Y, 2);
			distances[i] = Math.sqrt(x + y);
		}
		return distances;
	}
}

class Point
{
	public final double X, Y;

	public Point(double x, double y)
	{
		this.X = x;
		this.Y = y;
	}

	@Override
	public String toString()
	{
		return String.format("[X:%.2f Y:%.2f]", this.X, this.Y);
	}
}