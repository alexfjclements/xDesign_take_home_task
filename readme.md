This project is my solution to the take home task provided by xDesign. Data is
parsed from the munrotab_v6.2.csv file in the main project directory, evaluated,
and if it meets the appropriate criteria is entered into a list of munros. The
file may have extra lines of data added, but if the name is changed the new
name (without the extension) will need to be entered in the DataParser and
MunroList tests for those tests to continue to pass. The app also uses an
absolute path to locate that file, so that on a new machine the path surrounding
the file name will need to be updated in DataParser.java, line 31. 
