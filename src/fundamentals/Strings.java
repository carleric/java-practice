package fundamentals;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;



public class Strings {
	
	public boolean hasUniqueChars(String s){
		//assume ASCII
		boolean [] charmap = new boolean[256];
		
		for(char c : s.toCharArray()){
			if(charmap[c])
				return false;
			else
				charmap[c] = true;
		}
		return true;
	}

	public boolean isPermutation(String a, String b){
		if(a.length() != b.length())
			return false;
		else{
			return (sortString(a).equals(sortString(b)));
		}
	}
	
	public String sortString(String s){
		char [] chars = s.toCharArray();
		java.util.Arrays.sort(chars);
		return new String(chars);
	}
	
	/**
	 * 1.4
	 * O(n2)
	 */
	public String replaceSpaces(String s){
		char [] c_arr = s.toCharArray();
		for(int i=0; i<c_arr.length; i++){
			if(c_arr[i] == ' '){
				c_arr = insertChars("%20".toCharArray(), c_arr, i);
			}
		}
		return new String(c_arr);
	}
	
	public char [] insertChars(char [] from, char [] to, int at){
		Queue<Character> charQueue = new LinkedList<Character>();
		for(int i=at, j=0; j<from.length; i++, j++){
			if(to[i] != ' ')
				charQueue.offer(to[i]);
			to[i] = from[j];
		}
		for(int i=at+from.length; i<to.length; i++){
			charQueue.offer(to[i]);
			to[i] = charQueue.poll().charValue();
		}
		return to;
	}
	
	/**
	 * from 1.4 solution: doesn't work!
	 */
	public void replaceSpaces(char [] str, int length){
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++){
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		
		newLength = length + spaceCount *2;
		str[newLength] = '\0';
		for(i=length - 1; i >=0; i--){
			if(str[i] == ' '){
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength -3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		
	}
	
	public String compressString(String s){
		if(hasUniqueChars(s))
			return s;
		else{
			
		}
		return s;
	}
	
	public int factorial(int size){
		int fact = size;
		for(int i = size-1; i >0; i--){
			fact *= i;
		}
		return fact;
	}
	
	public ArrayList<String> getPermutations(String s){
		ArrayList<String> perms = new ArrayList<String>();
		if(s.length() ==1){
			perms.add(s);
		}
		else{
			//for(int i=0; i<s.length(); i++){
				char startChar = s.charAt(0);
				ArrayList <String>newperms = getPermutations(s.substring(1));
				//insert start char in each possible position in the newperms list.
				for(String perm : newperms){
					
					for(int j=0; j<=perm.length(); j++){
						StringBuilder newperm = new StringBuilder();
						if(j==0){
							newperm.append(startChar);
							newperm.append(perm);
						}else if(j == (perm.length())){
							newperm.append(perm);
							newperm.append(startChar);
						}else{
							newperm.append(perm.substring(0, j));
							newperm.append(startChar);
							newperm.append(perm.substring(j));
						}
						perms.add(newperm.toString());
					}
					
				}
			}
		//}
		return perms;
	}
	
	//assume contains valid words
	private static HashSet <String> dictionary = new HashSet();
	private static Hashtable <Integer, ArrayList> numberToWords = new Hashtable<Integer, ArrayList>();
	
	private static Hashtable <Integer, String> digitToLetterMap = new Hashtable<Integer, String> ();
	private static Hashtable <Character, Integer> letterToDigitMap = new Hashtable<Character, Integer>();
	
	{
		//add some valid words to the dictionary
		dictionary.add("cool");
		dictionary.add("bool");
		dictionary.add("annk");
		
		digitToLetterMap.put(new Integer(2), "abc");
		digitToLetterMap.put(new Integer(3), "def");
		digitToLetterMap.put(new Integer(4), "ghi");
		digitToLetterMap.put(new Integer(5), "jkl");
		digitToLetterMap.put(new Integer(6), "mno");
		digitToLetterMap.put(new Integer(7), "pqrs");
		digitToLetterMap.put(new Integer(8), "tuv");
		digitToLetterMap.put(new Integer(9), "wxyz");
		
		for(Integer i : digitToLetterMap.keySet()){
			char [] chars = digitToLetterMap.get(i).toCharArray();
			for(char ch : chars){
				letterToDigitMap.put(ch, i);
			}
		}
		
		for(String word : dictionary){
			char [] chars = word.toCharArray();
			StringBuilder sb = new StringBuilder();
			for(char ch : chars){
				sb.append(letterToDigitMap.get(ch));
			}
			Integer number = new Integer(sb.toString());
			ArrayList existingWords = numberToWords.get(number);
			if(existingWords == null){
				existingWords = new ArrayList();
				existingWords.add(word);
			}
			else if(!existingWords.contains(word))
				existingWords.add(word);
			numberToWords.put(new Integer(sb.toString()), existingWords);
		}
		
	}
	
	
	/**
	 * vanity numbers:
	 * given a 4 digit number and dictionary of valid words, write a function that will return a list of valid 4 letter words
	 * @param number: a 4 digit number
	 */
	public String [] getVanityNumbers(int number){
		ArrayList words = numberToWords.get(new Integer(number));
		String [] wordsArray = new String[words.size()];
		return (String []) words.toArray(wordsArray);
	}
	
	
}
