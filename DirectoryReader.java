//Name: Joe Bennett
//Assignment: Program 4
//Description: DirectoryReader contains a main method, a method visitDirectory,
//and a method proccess directory. Main asks the user for a name of a file
//directory, checks if it is a directory, and sends the directory as a file
//object to visit directory. Visit directory calls the method processDirectory,
//sending it an array of File objects for every file in the folder and a
//starting index of 0. processDirectory checks if each file in the array
//is a file or a folder itself, and adds to the private data fields bytes,
//files, and directories respectively. If it is a file, the index is itterated
//and method continues until the end. If it is a folder, the visitDirectory is 
//called and same process occurs recursively until that folder is completely 
//processed, and then the rest of the main folder continues processing with
//and index iteration and recursive call of of the proccessDirectory.
//Proccessing finishes when the base case is reached, that is when the index
//is iterated to the length of the array of Files sent to processDirectory
//Once all files, folders, and total bytes are processed, main prints the private
//static data fields for the user to see.
import java.io.File;
import java.util.Scanner;

public class DirectoryReader
{
   private static long bytes = 0;
   private static int files = 0;
   private static int directories = 0;
   private static int emptyRemoved = 0;

   
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the pathway to a directory:");
      File startDirectory = new File(in.nextLine());
      if(startDirectory.isDirectory()==true)
      {
      	 directories++;
         visitDirectory(startDirectory, 0);
         //prints final value of data fields
         System.out.println("Bytes in directory: "+bytes);
         System.out.println("Files: "+files);
         System.out.println("Subdirectories: "+directories);
         System.out.println("Empty Directories Removed: "+emptyRemoved);

      }
      else
      {
         System.out.println("Error. Invalid directory pathway.");
      }
   }
   
   public static void visitDirectory(File directory, int index)
   {
   		if(directory.listFiles().length ==0){
			boolean delete = directory.delete();
			if(delete){
				emptyRemoved++;
			}
		}
		else{
         	processDirectory(directory.listFiles(), index);
         }
   }
   public static void processDirectory(File[] directory,int index)
   {
     //base case to check if entire folder has been scanned or is empty
     if(directory.length == index);
     //checks if the current index is a folder
     else if(directory[index].isDirectory())
      {
         //updates folder count
         directories++;
         //moves to within the selected folder
         visitDirectory(directory[index], 0);
         index++;
         //continues inside folder once subfolder is proccessed
         processDirectory(directory, index);
      }   
      else
         {
            //updates data fields
            files++;
            bytes= bytes + directory[index].length();
            index++;
            //recursively continues proccessing folder contents
            processDirectory(directory, index);
         }   
   }
}