package com.kevinmitcham.interview;
import java.util.ArrayList;
import java.util.Iterator;

public class TextJustify {
	boolean debug = false;
	char SPACE = '.';
	String[] textJustification(String[] words, int L) {
	    ArrayList<String> output = new ArrayList();
	    for (int i=0; i < words.length;){
	        StringBuilder  sb = new StringBuilder();
	        int lineLength = 0;
	        boolean first = true;
	        int j = 0;
	        ArrayList<String> lineWords = new ArrayList();
	        while ( (i+j) < words.length ){
	        	String word = words[i+j]; // the next word
	        	int wordLength = word.length();
	        	// can the word fit on this line?
//        		p("    word "+word+ " line is at "+lineLength);
	        	if ( first ){
	        		lineWords.add(word);
	        		lineLength += wordLength;
	        		first = false;
	        		j++;
	        	} else if (lineLength + wordLength +1 <= L){
	        		lineWords.add(word);
	        		lineLength+= 1+wordLength;
	        		j++;
	        	} else {
//	        		p("overflow "+j+ " total="+(lineLength + wordLength +1));
	        		break;
	        	}	
	        }
	//        p(" lineLength is "+lineLength+" j="+j);
	        // j words on the line.  baselength of line is total
	        int padding = L- lineLength;
	        int perWord = padding;
	        int modulo = 0; // in case padding isn't even
	        if (lineWords.size() > 2){
	        	// we need to allocate the padding
	        	perWord = padding/(lineWords.size()-1) ; // 3 words->2 separations
	        	modulo = padding % (lineWords.size()-1);
	        }
	  //      p(" found "+j+" words for line, total min length "+lineLength);
	        // handle padding
	        sb.append(lineWords.get(0));
	        i++;
	        for (int k=1; k< lineWords.size();k++ ){
	        	i++;
        		sb.append(SPACE);
	        	for (int a=0; a < perWord; a++){
	        		sb.append(SPACE);
	        	}
	        	if (modulo > 0){
	        		modulo--;
	        		sb.append(SPACE);
	        	}
	        	sb.append(lineWords.get(k));
	        }
	        while (sb.length() < L){
	        	sb.append(SPACE);
	        }
	        
	        //p("Line >>"+sb.toString()+"<<");
	        output.add(sb.toString());	            
	    }
	    String[] out = new String[output.size()];
	    output.toArray(out);
	    return out;
	}
	void p(String msg){
		if (debug){
			System.out.println(msg);
		}
	}
}
