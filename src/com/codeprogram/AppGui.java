package com.codeprogram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AppGui implements ActionListener {
    JFrame eF = new JFrame("Задача 7");
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    final JList<Integer> termOne = new JList<>();
    final JList<Integer> termTwo = new JList<>();
    final JList<Integer> sum = new JList<>();
    JButton btnSum = new JButton("Згенерувати");

    public AppGui() {
        eF.setSize(500, 300);
        eF.setResizable(false);
        eF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eF.setLayout(new BorderLayout());


        JScrollPane termOneScrollPane = new JScrollPane();
        termOneScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        termOneScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        termOneScrollPane.setViewportView(termOne);
        termOne.setLayoutOrientation(JList.VERTICAL);
        termOneScrollPane.setPreferredSize(new Dimension(100, 200));
        northPanel.add(termOneScrollPane);

        JScrollPane termTwoScrollPane = new JScrollPane();
        termTwoScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        termTwoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        termTwoScrollPane.setViewportView(termTwo);
        termOne.setLayoutOrientation(JList.VERTICAL);
        termTwoScrollPane.setPreferredSize(new Dimension(100, 200));
        northPanel.add(termTwoScrollPane);

        JScrollPane sumScrollPane = new JScrollPane();
        sumScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sumScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sumScrollPane.setViewportView(sum);
        termOne.setLayoutOrientation(JList.VERTICAL);
        sumScrollPane.setPreferredSize(new Dimension(100, 200));
        northPanel.add(sumScrollPane);

        centerPanel.add(btnSum);
        eF.add(centerPanel, BorderLayout.CENTER);
        eF.add(northPanel, BorderLayout.NORTH);
        this.btnSum.addActionListener(this);
        eF.setVisible(true);
    }

    public static void main(String[] args) {
        new AppGui();
    }

    Integer[] generateRandomArray(int size) {
        Random rd = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(100);
        }
        return arr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnSum)) {
            int arrSize = new Random().nextInt(19) + 1;
            Integer[] termOneData = generateRandomArray(arrSize);
            termOne.setListData(termOneData);
            Integer[] termTwoData = generateRandomArray(arrSize);
            termTwo.setListData(termTwoData);
            Integer[] sumData = new Integer[arrSize];
            for (int index = 0; index < arrSize; index++) {
                sumData[index] = termOneData[index] + termTwoData[index];
            }
            sum.setListData(sumData);

        }
    }
}