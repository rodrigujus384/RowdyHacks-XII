package cs2.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("unused")
public class Sampler {

    private HashMap<String, Integer> list;

    public Sampler() {
        list = new HashMap<String, Integer>();
    }

    public Sampler(String url) {
        HashMap<String, Integer> reader = new HashMap<String, Integer>();
    
    try {
    File file = new File(url);
    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split("\t");
        String word = parts[0];
        int freq = Integer.parseInt(parts[1]);
        reader.put(word, freq);
    }
    scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred when trying to open the file.");
    }
    list = reader;
    }

    public Set<String> getWords() {
        return list.keySet();
    }

    public int getCount(String word) {
        if (!list.containsKey(word)) {return 0;}
        return list.get(word);
    }

    public int totalCount() {
        int counting = 0;
        Set<String> ReadMe = list.keySet();
        for (String word : ReadMe) {
            counting += list.get(word);
        }
        return counting;
    }

    public double getProbability(String word) {
        return (double) this.getCount(word) / this.totalCount();
    }

    public void increment(String key) {
        if (!list.containsKey(key)) {list.put(key, 1);}
        else if (list.containsKey(key)) {
            int NewValue = list.get(key) + 1;
            list.put(key, NewValue);
        }
    }

    public String sample() {
        double determine = Math.random();
        double collect = 0.0;
        for (String word : this.getWords()) {
            collect += this.getProbability(word);
            if (determine <= collect) {
                return word;
            }
        }
        // Set<String> words = this.getWords();
        // ArrayList<Integer> probs = new ArrayList<>();
        // HashMap<Integer, String> duck = new HashMap<Integer, String>();
        // for (String k : words) {
        //     int g = (int)(this.getProbability(k));
        //     probs.add(g);
        //     duck.put(g, k);
        // }
        // Collections.sort(probs);
        // int determine = (int)(Math.random() * probs.get((probs.size())-1)+1);
        // for (int i=0; i<probs.size(); i++) {
        //     if (determine <= probs.get(i)) {
        //         return duck.get(probs.get(i));
        //     }
        // }
        return "error!";
    }
}
