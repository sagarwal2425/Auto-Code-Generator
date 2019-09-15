package pom;

import java.io.*;

public class PageGenerator {
	
	private static final String FILENAME = "C:\\Users\\shubh\\Google Drive\\Projects\\AutoCode Generator\\codeGenerated.txt";
	static FileWriter fstream ;
	static BufferedWriter out;
	static String Output = "";
	
	public void elementValueCreation(String webelement) throws IOException {
		String text = "String " + webelement + "Value = getValueIfFound(json,\"\" );\r\n" ;
		Output = Output + text;
	}
	
	public void elementPathCreation(String elementPath,String webelement) throws IOException {
		String text = "@FindBy(" + elementPath + ")\r\n" + "private WebElement " + 
						webelement.substring(0, 1).toLowerCase() + webelement.substring(1) + "; \r" ;
		Output = Output + text;
	}

	public static  String textboxMethod(String element) {
		String text = "\r\npublic void enter" + element + "(String text) throws Exception {\r\n" + 
						"\t if (!text.equalsIgnoreCase(\"NA\")) {\r\n \t \t " + 
						element + ".sendKeys(\"text\")" + "\r\n\t \t System.out.println(\"Value is entered in " +
						element + "!!\");\r\n	    }\r\n}\r\n\r";
		return text;
	}

	public static  String dropDowmMethod(String element) {
		String text = "public void select" + element + "(String text) throws Exception {\r\n" + 
					  "\t if (!text.equalsIgnoreCase(\"NA\")) {\r\n \t \t " + 
					  element + ".selectByVisibleText(\"text\")" + "\r\n \t \t System.out.println(\"Value is selected in " +
					  element + "!!\");\r\n	    }\r\n}\r\n\r";
		return text;
	}

	public static  String buttonMethod(String element) {
		String text = "public void click" + element + "(String text) throws Exception {\r\n" + 
					  "\t if (!text.equalsIgnoreCase(\"NA\")) {\r\n \t \t " + 
					  element + ".click()" +"\r\n \t \t System.out.println(\"" + element + 
					  " is clicked!!\");\r\n	    }\r\n}\r\n\r";
		return text;
	}

	public static String radioButtonMethod(String element) {
		String text = "public void click" + element + "(String text) throws Exception {\r\n" + 
					  "\t if (!text.equalsIgnoreCase(\"NA\")) {\r\n \t \t " + 
					  element + ".click()" + "\r\n \t \t System.out.println(\"" + element +
					  " is clicked!!\");\r\n	    }\r\n}\r\n\r";
		return text;
	}
	
	public static String checkBoxMethod(String element) {
		String text = "public void click" + element + "(String text) throws Exception {\r\n" + 
					  "\t if (!text.equalsIgnoreCase(\"NA\")) {\r\n \t \t " + 
					  element + ".click()" + "\r\n \t \t System.out.println(\"" + element +
					  " is checked!!\");\r\n	    }\r\n}\r\n\r";
		return text;
	}
	
	// Create a new file output stream.
	public void methodCreation(String element, String typeOfelement) throws IOException {
		
		switch (typeOfelement.toUpperCase()) {
		case "TEXT":
			String methodValue = textboxMethod(element);
			Output = Output + methodValue;
			break;
			
		case "DROPDOWN":
			String dropDownValue = dropDowmMethod(element);
			Output = Output + dropDownValue;
			break;
	
		case "BUTTON":
			String checkboxValue = buttonMethod(element);
			Output = Output + checkboxValue;
			break;
		
		case "CHECKBOX":
			String checkBox = checkBoxMethod(element);
			Output = Output + checkBox;
			break;
		
		case "RADIOBUTTON":
			String radioButton = radioButtonMethod(element);
			Output = Output + radioButton;
			break;
		}
	}
	
	public void pageCreation(String element, String typeOfelement) throws IOException {
			
		switch (typeOfelement.toUpperCase()) {
		case "TEXT":
			String methodValue = "enter" + element + "(" + element.substring(0, 1).toLowerCase() + element.substring(1) + "Value);\r\n";
			Output = Output + methodValue;
			break;

		case "DROPDOWN":
			String dropDownValue = "select" + element + "(" + element.substring(0, 1).toLowerCase() + element.substring(1) + "Value);\r\n";
			Output = Output + dropDownValue;
			break;

		case "BUTTON":
			String buttonValue = "click" + element + "(" + element.substring(0, 1).toLowerCase() + element.substring(1) + "Button);\r\n";
			Output = Output + buttonValue;
			break;

		case "CHECKBOX":
			String checkboxValue = "check" + element + "(" + element.substring(0, 1).toLowerCase() + element.substring(1) + "Box);\r\n";
			Output = Output + checkboxValue;
			break;
		
		case "RADIOBUTTON":
			String radioButtonValue = "click" + element + "(" + element.substring(0, 1).toLowerCase() + element.substring(1) + "RadioButton);\r\n";
			Output = Output + radioButtonValue;
			break;
		}
	}
	
	//For writing data into the text file
	public void fileData() throws IOException {
		  fstream = new FileWriter(FILENAME, false);
		  out = new BufferedWriter(fstream);
		  out.write(Output);
		  out.flush();
		  out.close();
		  System.out.println("POM Class file Generated");
    }
}