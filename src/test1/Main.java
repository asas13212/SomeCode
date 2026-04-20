package test1;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main extends X {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().createAndShowUI());
    }

    private void createAndShowUI() {
        JFrame frame = new JFrame("定时关机工具");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 180);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel statusLabel = new JLabel("点击按钮后将在 3 小时后自动关机。");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton shutdownBtn = new JButton("3小时后关机");
        JButton cancelBtn = new JButton("取消已计划的关机");

        shutdownBtn.addActionListener(e -> scheduleShutdown(frame, statusLabel, shutdownBtn));
        cancelBtn.addActionListener(e -> cancelShutdown(frame, statusLabel, shutdownBtn));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        btnPanel.add(shutdownBtn);
        btnPanel.add(cancelBtn);

        panel.add(statusLabel, BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    private void scheduleShutdown(JFrame frame, JLabel statusLabel, JButton shutdownBtn) {
        int result = JOptionPane.showConfirmDialog(
                frame,
                "确认要在 3 小时后关机吗？",
                "确认操作",
                JOptionPane.YES_NO_OPTION
        );
        if (result != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            new ProcessBuilder("shutdown", "/s", "/t", "10800").start();
            statusLabel.setText("已设置：3小时后自动关机（可点击“取消已计划的关机”撤销）");
            shutdownBtn.setEnabled(false);
            JOptionPane.showMessageDialog(frame, "设置成功：3小时后自动关机。");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "设置失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelShutdown(JFrame frame, JLabel statusLabel, JButton shutdownBtn) {
        try {
            new ProcessBuilder("shutdown", "/a").start();
            statusLabel.setText("已取消关机计划。");
            shutdownBtn.setEnabled(true);
            JOptionPane.showMessageDialog(frame, "已取消已计划的关机。");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "取消失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class X extends F {
    Y y = new Y();

    X() {
        System.out.println("X");
    }
}

class F {
    F() {
        System.out.println("F");
    }
    // 我就加一个注释
}

class Y {
    Y() {
        System.out.println("Y");
    }
}
