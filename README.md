Description: DirectoryReader contains a main method, a method visitDirectory,
and a method proccess directory. Main asks the user for a name of a file
directory, checks if it is a directory, and sends the directory as a file
object to visit directory. Visit directory calls the method processDirectory,
sending it an array of File objects for every file in the folder and a
starting index of 0. processDirectory checks if each file in the array
is a file or a folder itself, and adds to the private data fields bytes,
files, and directories respectively. If it is a file, the index is itterated
and method continues until the end. If it is a folder, the visitDirectory is 
called and same process occurs recursively until that folder is completely 
processed, and then the rest of the main folder continues processing with
and index iteration and recursive call of of the proccessDirectory.
The exception is if a folder is empty, in which case the program attempts
to delete the empty folder and increases the count of empty deleted directories
removed during this run of the program.Processing finishes when the base case is reached, 
that is when the index is iterated to the length of the array of Files sent 
to processDirectoryOnce all files, folders, and total bytes are processed, 
main prints the private static data fields for the user to see.