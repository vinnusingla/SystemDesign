package com.vinayak.practice.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Tile>> board;

    public Board(int siz) {
        this.size = siz;
        board = new ArrayList<>();
        for (int i = 0; i < siz; i++) {
            List<Tile> row = new ArrayList<Tile>();
            for (int j = 0; j < siz; j++) {
                row.add(new Tile());
            }
            board.add(row);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBoard = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                stringBoard.append(board.get(i).get(j).toString() + " ");
            }
            stringBoard.append("\n");
        }
        return stringBoard.toString();
    }

    public boolean isEmpty(int x, int y) {
        return board.get(x).get(y).isEmpty();
    }

    public void markValue(int x, int y, String val) {
        board.get(x).get(y).setValue(val);
    }

    public String findValue(int x, int y) {
        return board.get(x).get(y).getValue();
    }
}
