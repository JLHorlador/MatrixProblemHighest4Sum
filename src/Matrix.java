import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner reader = new Scanner(new File("MatrixVariables.dat"));
		int[][] matrix = new int[12][10];
		
		for (int y = 0; y < 10; y++)
		{
			for (int x = 0; x < 12; x++)
			{
				if (reader.hasNextInt())
				{
					matrix[x][y] = reader.nextInt();
				}
				if (matrix[x][y] < 10)
					System.out.print(matrix[x][y] + "  ");
				else
					System.out.print(matrix[x][y] + " ");
			}
			System.out.print("\n");
		}
		reader.close();
		
		int highestSum = 0;		//the highest sum
		int chosenNum = 0;		//currently chosen number
		int xCounter = 0;
		int yCounter = 0;
		int sumN = 0;
		int sumE = 0;
		int sumS = 0;
		int sumW = 0;
		int highestNum1 = 0;
		int highestNum2 = 0;
		int highestNum3 = 0;
		int highestNum4 = 0;
		
		while (yCounter < 10 && xCounter < 12)
		{
			chosenNum = matrix[xCounter][yCounter];
			System.out.println("\nmatrix[" + xCounter + "][" + yCounter + "] -> " + chosenNum + ":" );
			sumN = checkNorth(matrix, chosenNum, xCounter, yCounter);
			sumE = checkEast(matrix, chosenNum, xCounter, yCounter);
			sumS = checkSouth(matrix, chosenNum, xCounter, yCounter);
			sumW = checkWest(matrix, chosenNum, xCounter, yCounter);
			if (sumN > sumE && sumN > sumS && sumN > sumW && sumN > highestSum)
			{
				highestSum = sumN;
				highestNum1 = chosenNum;
				highestNum2 = matrix[xCounter][yCounter - 1];
				highestNum3 = matrix[xCounter][yCounter - 2];
				highestNum4 = matrix[xCounter][yCounter - 3];
			}
			else if (sumE > sumN && sumE > sumS && sumE > sumW && sumE > highestSum)
			{
				highestSum = sumE;
				highestNum1 = chosenNum;
				highestNum2 = matrix[xCounter + 1][yCounter];
				highestNum3 = matrix[xCounter + 2][yCounter];
				highestNum4 = matrix[xCounter + 3][yCounter];
			}
			else if (sumS > sumE && sumS > sumN && sumS > sumW && sumS > highestSum)
			{
				highestSum = sumS;
				highestNum1 = chosenNum;
				highestNum2 = matrix[xCounter][yCounter + 1];
				highestNum3 = matrix[xCounter][yCounter + 2];
				highestNum4 = matrix[xCounter][yCounter + 3];
			}
			else if (sumW > sumE && sumW > sumN && sumW > sumS && sumW > highestSum)
			{
				highestSum = sumW;
				highestNum1 = chosenNum;
				highestNum2 = matrix[xCounter - 1][yCounter];
				highestNum3 = matrix[xCounter - 2][yCounter];
				highestNum4 = matrix[xCounter - 3][yCounter];
			}

			yCounter++;
			if (yCounter > 9)
			{
				xCounter++;
				yCounter = 0;
			}
			
			sumN = 0;
			sumE = 0;
			sumS = 0;
			sumW = 0;
		}
		System.out.println("\n\nhighestSum: " + highestSum +
							"\nNumbers: " + highestNum1 + " " + highestNum2 + " " + highestNum3 + " " +highestNum4 + " ");
	}
	
	private static int checkNorth(int[][] matrix, int chosenNum, int x, int y)
	{
		if (y - 3 >= 0)
		{
			int num2 = matrix[x][y - 1];
			int num3 = matrix[x][y - 2];
			int num4 = matrix[x][y - 3];
			int sum = chosenNum + num2 + num3 + num4;
			System.out.print("N: " + sum + " ");
			return sum;
		}
		return 0;
	}
	
	private static int checkEast(int[][] matrix, int chosenNum, int x, int y)
	{
		if (x + 3 < 12)
		{
			int num2 = matrix[x + 1][y];
			int num3 = matrix[x + 2][y];
			int num4 = matrix[x + 3][y];
			int sum = chosenNum + num2 + num3 + num4;
			System.out.print("E: " + sum + " ");
			return sum;
		}
		return 0;
	}
	
	private static int checkSouth (int[][] matrix, int chosenNum, int x, int y)
	{
		if (y + 3 < 10)
		{
			int num2 = matrix[x][y + 1];
			int num3 = matrix[x][y + 2];
			int num4 = matrix[x][y + 3];
			int sum = chosenNum + num2 + num3 + num4;
			System.out.print("S: " + sum + " ");
			return sum;
		}
		return 0;
	}
	
	private static int checkWest(int[][] matrix, int chosenNum, int x, int y)
	{
		if (x - 3 >= 0)
		{
			int num2 = matrix[x - 1][y];
			int num3 = matrix[x - 2][y];
			int num4 = matrix[x - 3][y];
			int sum = chosenNum + num2 + num3 + num4;
			System.out.print("W: " + sum + " ");
			return sum;
		}
		return 0;
	}
}
