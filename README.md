# RNAtoProteinsConverter
This program is converting RNA (ribonucleic acid, complex compound of high molecular weight that functions in cellular protein synthesis and replaces DNA) into the Proteins. 

  This program is converting RNA into the Proteins. First program read the RNA
  from RNASequenceData.txt and placing it into the  RNA string. Then, the
  program split the string into the characters and scan for the UGA. If the 
  program found UGA, scanner will continue to scan string by three characters
  at a time and convert this characters into Amino acids by calling the method 
  codonLookup. If the program scan UAG, UGA, UAA, the program will stop to scan
  and start to scan for new UGA, until the end of the string. 
  The program also using methods to run the program. Which I will describe 
  on the top of all methods
