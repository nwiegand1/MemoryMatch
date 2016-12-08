import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

public class HighscoreFunction //throws IOException
{
//	public Writer savedScores;
//	public Reader reader;
//	BufferedReader br = new BufferedReader(reader);
	
	//InputStream highscoreDoc = new FileInputStream (textFileOfHighscores);
	//InputStream highscoreBR = new  BufferedInputStream (highscoreDoc);
	
	//String line = br.readLine();
//	String[] arrOfNameAndScores = line.split(" ");
	
	public HighscoreFunction() 
	{
		//BufferedReader br = new BufferedReader(reader);
		//this.line = br.readLine();
	}
	/*
	public String readHighscores()
	{
	BufferedReader br;
	try {
		br = new BufferedReader(new FileReader("textFileOfHighscores.txt"));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();

	    while (line != null) {
	    	String[] arrOfNameAndScores = line.split(" ");
			String scoreToAdd = "Flips: " + arrOfNameAndScores[0] + " Name: " + arrOfNameAndScores[1];
	        sb.append(line);
	        sb.append(System.lineSeparator());
	        line = br.readLine();
	    }
	    String everything = sb.toString();
	    return everything;
	} finally {
	    br.close();
	}
	}
	
	*/
	
	
	public String readHighscore()
	{
		int highScore = 0;
		String toReturn = "";
		try {
	        BufferedReader reader = new BufferedReader(new FileReader("textFileOfHighscores"));
	        String line = reader.readLine();
	        while (line != null)                 // read the score file line by line
	        {
	            try {
	            	toReturn = toReturn + getNameAndScore(line);
	                
	            } catch (NumberFormatException e1) {
	                // ignore invalid scores
	                //System.err.println("ignoring invalid score: " + line);
	            }
	            line = reader.readLine();
	        }
	        reader.close();

	    } catch (IOException ex) {
	        System.err.println("ERROR reading scores from file");
	    }
		return toReturn;
	}
	
	public void displayScores()
	{
		String scores = readHighscore();
		/*
		while (line != null)
		{
			String line = br.readLine();
			String[] arrOfNameAndScores = line.split(" ");
			scores = scores + "Flips: " + arrOfNameAndScores[0] + " Name: " + arrOfNameAndScores[1];
		}
		*/
		JOptionPane.showMessageDialog(null, scores);
	}
	
	public void addScore(String name, int flips)
	{
		 try {
		        BufferedWriter output = new BufferedWriter(new FileWriter("textFileOfHighscores", true));
		        output.newLine();
		        output.append(name + " " + flips);
		        output.close();
		        System.out.println ("added score" + name + flips);

		    } catch (IOException ex1) {
		        System.out.printf("ERROR writing score to file: %s\n", ex1);
		    }
		
		/*
		List lines = highscore.readSmallTextFile("textFileOfHighscores.txt");
	    log(lines);
	    lines.add("This is a line added in code.");
	    highscore.writeSmallTextFile(lines, "textFileOfHighscores.txt");
	    */
	}
	
	
	public String getNameAndScore (String line)
	{
		System.out.println (line);
		char[] arr = line.toCharArray();
		String name = "";
		String score = "";
		int i = 0;
		/*while (Character.isLetter(arr[i]))
		{
			name = name + arr[i];
			i++;
		}
		i++; //skip over space 
		while(Character.isDigit(arr[i]) && i < arr.length)
		{
			score = score + arr[i];
			i++;
		}
		//System.out.println (name); */
		String[] arrOfNameAndScores = line.split(" ");
		name = arrOfNameAndScores[0];
		score = arrOfNameAndScores[1];
		return ("Name: " + name + " Score: " + score +"\n");
	}
	
/*	
	public void addNameAndScore (int score, String name)
	{
		try {
			savedScores.write(name + " " + score);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
