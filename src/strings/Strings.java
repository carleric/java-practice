package strings;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Collection;
import java.lang.Character;
import java.util.Arrays;

public class Strings {
	
	public static boolean hasUniqueChars(String s){
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

	public static boolean isPermutation(String a, String b){
		if(a.length() != b.length())
			return false;
		else{
			return (sortString(a).equals(sortString(b)));
		}
	}
	
	public static String sortString(String s){
		char [] chars = s.toCharArray();
		java.util.Arrays.sort(chars);
		return new String(chars);
	}
	
	/**
	 * Problem 1.4 from Cracking the Coding Interview by Gayle Laakmann McDowell
	 * O(n2)
	 */
	public static String replaceSpaces(String s){
		char [] c_arr = s.toCharArray();
		for(int i=0; i<c_arr.length; i++){
			if(c_arr[i] == ' '){
				c_arr = insertChars("%20".toCharArray(), c_arr, i);
			}
		}
		return new String(c_arr);
	}
	
	public static char [] insertChars(char [] from, char [] to, int at){
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
	 * from 1.4 solution
	 */
	public static void replaceSpaces(char [] str, int length){		
		int end = str.length;
		for(int i=length - 1; i >=0; i--){
			if(str[i] == ' '){
				str[end - 1] = '0';
				str[end - 2] = '2';
				str[end - 3] = '%';
				end = end -3;
			} else {
				str[end - 1] = str[i];
				end = end - 1;
			}
		}
		
	}
	
	public static int factorial(int size){
        int fact = size;
        for(int i = size-1; i > 0; i--){
            fact *= i;
        }
        return fact;
	}
	
	public static ArrayList<String> getPermutations(String s){
        if(s == "") {
            return new ArrayList<String>(Arrays.asList(new String[]{""}));
        }
        
        ArrayList<String> perms = new ArrayList<String>();
        if(s.length() == 1){
            perms.add(s);
        }
        else{
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

        return perms;
	}
	

	
	
	//assume contains valid words
	private static HashSet <String> dictionary = new HashSet();
	private static Hashtable <Integer, ArrayList> numberToWords = new Hashtable<Integer, ArrayList>();
	
	private static Hashtable <Integer, String> digitToLetterMap = new Hashtable<Integer, String> ();
	private static Hashtable <Character, Integer> letterToDigitMap = new Hashtable<Character, Integer>();
	
	static{
		//add some valid words to the dictionary
		dictionary.add("cool");
		dictionary.add("bool");
		dictionary.add("annk");
		dictionary.add("dood");
		
		//phone digit key to letter map
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
	public static String [] getVanityNumbers(int number){
		ArrayList words = numberToWords.get(new Integer(number));
		String [] wordsArray = new String[words.size()];
		return (String []) words.toArray(wordsArray);
	}
        
       /**
        * 
        * @param <T>
        * @param list
        * @return 
        */ 
       public static <T> List<List<T>> powerset(Collection<T> list) {
           List<List<T>> ps = new ArrayList<List<T>>();
           ps.add(new ArrayList<T>()); //add the empty set
           
           //for every item in the orginal set
           for(T item : list) {
               List<List<T>> newPs = new ArrayList<List<T>>();
               
               for (List<T> subset : ps) {
                   // copy all of the current powerset's subsets
                   newPs.add(subset);
                   
                   //plus the subsets appended with the current item
                   List<T> newSubset = new ArrayList<T>(subset);
                   newSubset.add(item);
                   newPs.add(newSubset);
               }
               
               ps = newPs;
           }
           return ps;
       }
        
        private static String getStringRepresentation(List<Character> list)
        {   
            if(list.size() == 0) return "";
            StringBuilder builder = new StringBuilder(list.size());
            for(Character ch: list)
            {
                builder.append(ch);
            }
            return builder.toString();
        }
        
        public static class StringLengthComparator implements java.util.Comparator<String> {

            private int referenceLength;

            public StringLengthComparator(String reference) {
                super();
                this.referenceLength = reference.length();
            }

            public int compare(String s1, String s2) {
                int dist1 = Math.abs(s1.length() - referenceLength);
                int dist2 = Math.abs(s2.length() - referenceLength);

                return dist1 - dist2;
            }
        }
        
        /**
         * given a dictionary of valid words, and a set of 7 characters, determine the longest valid
         * word that can be made with those characters
         */
        public static String getLongestWord(String [] validWords, Character [] characters) {
            ArrayList<String> validWordsAry = new ArrayList<String>(Arrays.asList(validWords));
            
            //get the powerset of the characters
            ArrayList<Character> charAry = new ArrayList<Character>(Arrays.asList(characters));
            List<List<Character>> ps = powerset(charAry);
            System.out.println(String.format("powerset size=%d", ps.size()));
            
            //for each powerset, get the permutations
            ArrayList <String>perms = new ArrayList<String>();
            for(List<Character> set : ps) {
                String s = getStringRepresentation(set);
                ArrayList <String> prms = getPermutations(s);
                perms.addAll(prms);
            }
            
//            for(String validWord : validWordsAry) {
//            	if(perms.contains(validWord)){
//            		return validWord;
//            	}
//            }
            
            
            //sort the perms by length
            StringLengthComparator c = new StringLengthComparator(getStringRepresentation(charAry));
            perms.sort(c);
            System.out.println(String.format("generated %d permutations", perms.size()) );
            
            //for each perm, check if it is in validWords
            int i = 0;
            for(String perm : perms) {
            	//System.out.println(String.format("testing word \"%s\" at index=%d", perm, i));
                if(validWordsAry.contains(perm)) {
                	System.out.println(String.format("found word \"%s\" at index=%d", perm, i));
                    return perm;
                }
                i++;
            }
            
            return null;
        }
	
	
}
