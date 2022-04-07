package main.java.com.alura.challenge.interfaces;


import java.util.List;

public interface JsonParser {
    public List<? extends Content> parse(String responseIMDB);
}
