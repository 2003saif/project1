import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MentalHealthCenterGUI extends JFrame implements ActionListener {

    private JPanel inputPanel;
    private JLabel nameLabel, specializationLabel, salaryLabel, behaviorLabel, prescriptionLabel, phdLabel;
    private JTextField nameField, specializationField, salaryField, behaviorField, prescriptionField , phdField;
    private JButton addTherapistButton, addPsychiatristButton, addPsychologistButton, updateButton, removeButton, displayButton;
    
    private JTextArea professionalsTextArea, bonusTextArea, averageBonusTextArea;

    private MentalHealthCenter mentalHealthCenter;
    private JTabbedPane tabbedPane;

    public MentalHealthCenterGUI() {
        mentalHealthCenter = new MentalHealthCenter("Find the Light");
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        inputPanel = new JPanel(new GridLayout(7, 2));
        inputPanel.setBackground(new Color(240, 240, 240));

        nameLabel = new JLabel("Name:");
        specializationLabel = new JLabel("Specialization:");
        salaryLabel = new JLabel("Salary:");
        behaviorLabel = new JLabel("Behavior (Therapist only):");
        prescriptionLabel = new JLabel("Prescription (Psychiatrist only):");
        phdLabel = new JLabel("Phd (Psychologist only):");

        nameField = new JTextField();
        specializationField = new JTextField();
        salaryField = new JTextField();
        behaviorField = new JTextField();
        prescriptionField = new JTextField();
        phdField = new JTextField();

        addTherapistButton = new JButton("Add Therapist");
        addPsychiatristButton = new JButton("Add Psychiatrist");
        addPsychologistButton = new JButton("Add Psychologist");
        updateButton = new JButton("Update Specialization");
        removeButton = new JButton("Remove Professional");
//        displayButton = new JButton("Display Professionals");
        JButton saveButton = new JButton("Save Professionals to File"); 
        JButton loadButton = new JButton("Load Professionals from File"); 

        addTherapistButton.setBackground(new Color(144, 238, 144));
        addPsychiatristButton.setBackground(new Color(255, 192, 203));
        addPsychologistButton.setBackground(new Color(255, 255, 153));
        updateButton.setBackground(new Color(255, 215, 0));
        removeButton.setBackground(new Color(220, 20, 60));
//        displayButton.setBackground(new Color(135, 206, 250));
        saveButton.setBackground(Color.BLACK);
        loadButton.setBackground(Color.CYAN);
        
        
        
        inputPanel.add(nameLabel);
        inputPanel.add(specializationLabel);
        inputPanel.add(salaryLabel);
        inputPanel.add(nameField);
        inputPanel.add(specializationField);
        inputPanel.add(salaryField);
        inputPanel.add(behaviorLabel);
        inputPanel.add(prescriptionLabel);
        inputPanel.add(phdLabel);
        inputPanel.add(behaviorField);
        inputPanel.add(prescriptionField);
        inputPanel.add(phdField);
        inputPanel.add(addTherapistButton);
        inputPanel.add(addPsychiatristButton);
        inputPanel.add(addPsychologistButton);
        inputPanel.add(updateButton);
        inputPanel.add(removeButton);
//        inputPanel.add(displayButton);
        inputPanel.add(saveButton);
        inputPanel.add(loadButton); 
        
        professionalsTextArea = new JTextArea();
        bonusTextArea = new JTextArea();
        averageBonusTextArea = new JTextArea();

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Edit", inputPanel);
        tabbedPane.addTab("Display", new JScrollPane(professionalsTextArea));
        tabbedPane.addTab("Bonus", new JScrollPane(bonusTextArea));
        tabbedPane.addTab("Average Bonus", new JScrollPane(averageBonusTextArea));

        add(tabbedPane);

        addTherapistButton.addActionListener(this);
        addPsychiatristButton.addActionListener(this);
        addPsychologistButton.addActionListener(this);
        updateButton.addActionListener(this);
        removeButton.addActionListener(this);
//        displayButton.addActionListener(this);
        saveButton.addActionListener(e -> savePToFile());  
        loadButton.addActionListener(e -> loadPFromFile());  
        

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addProfessional(MentalHealthProfessional professional) {
        try {
            mentalHealthCenter.addProfessional(professional);
            JOptionPane.showMessageDialog(inputPanel, "Professional added successfully.");
            nameField.setText("");
            specializationField.setText("");
            salaryField.setText("");
            behaviorField.setText("");
            prescriptionField.setText("");
            phdField.setText("");
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(inputPanel, ex.getMessage());
        }
    }

    private void updateSpecialization(String name, String newSpecialization) {
        if (mentalHealthCenter.updateSpecialization(name, newSpecialization)) {
            JOptionPane.showMessageDialog(inputPanel, "Specialization updated successfully.");
            nameField.setText("");
            specializationField.setText("");
            salaryField.setText("");
            behaviorField.setText("");
            prescriptionField.setText("");
            phdField.setText("");
        } else {
            JOptionPane.showMessageDialog(inputPanel, "Professional not found.");
        }
    }

    private void removeProfessional(String name, String specialization, String salary, String behavior, String prescription, String phd) {
        try {
            MentalHealthProfessional professional = null;
            if (!behavior.isEmpty()) {
                professional = new Therapist(name, specialization, Double.parseDouble(salary), behavior);
            } else if (!prescription.isEmpty()) {
                professional = new Psychiatrist(name, specialization, Double.parseDouble(salary), prescription);
            } else {
                professional = new Psychologist(name, specialization, Double.parseDouble(salary), phd);
            }
            if (mentalHealthCenter.removeProfessional(professional)) {
                JOptionPane.showMessageDialog(inputPanel, "Professional removed successfully.");
                nameField.setText("");
                specializationField.setText("");
                salaryField.setText("");
                behaviorField.setText("");
                prescriptionField.setText("");
                phdField.setText("");
            } else {
                JOptionPane.showMessageDialog(inputPanel, "Professional not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(inputPanel, "Invalid salary format.");
        } catch (ProfessionalNotFoundException ex) {
            JOptionPane.showMessageDialog(inputPanel, ex.getMessage());
        }
    }

    private void displayProfessionals() {
        professionalsTextArea.setText(mentalHealthCenter.toString());
        bonusTextArea.setText("Total Bonus: " + mentalHealthCenter.getTotalBonus());
        averageBonusTextArea.setText("Average Bonus: " + mentalHealthCenter.getAverageBonus());
        JOptionPane.showMessageDialog(inputPanel, "Display is ready.");
    }
    
    private void savePToFile() {  
        JFileChooser fileChooser = new JFileChooser();  
        fileChooser.setDialogTitle("Specify a file to save");  
        int userSelection = fileChooser.showSaveDialog(this);  
  
        if (userSelection == JFileChooser.APPROVE_OPTION) {  
            File fileToSave = fileChooser.getSelectedFile();  
            try {  
                mentalHealthCenter.savetofile(fileToSave.getAbsolutePath());  
                JOptionPane.showMessageDialog(this, "Data saved to file: " + fileToSave.getAbsolutePath());  
            } catch (IOException ex) {  
                JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage());  
            }  
        }  
    } 
    
    private void loadPFromFile() {  
        JFileChooser fileChooser = new JFileChooser();  
        fileChooser.setDialogTitle("Specify a file to load");  
        int userSelection = fileChooser.showOpenDialog(this);  
  
        if (userSelection == JFileChooser.APPROVE_OPTION) {  
            File fileToLoad = fileChooser.getSelectedFile();  
              
            MentalHealthProfessional[] loaded = new MentalHealthProfessional[20];  
            try {  
                mentalHealthCenter.LoadFromfile(fileToLoad.getAbsolutePath(), loaded);  
                for (MentalHealthProfessional p : loaded) {  
                    if (p != null) mentalHealthCenter.addProfessional(p);  
                }  
                displayProfessionals();  
                JOptionPane.showMessageDialog(this, "Data loaded from file: " + fileToLoad.getAbsolutePath());  
            } catch (IOException ex) {  
                JOptionPane.showMessageDialog(this, "Error loading from file: " + ex.getMessage());  
            }  
        }  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTherapistButton) {
            addProfessional(new Therapist(nameField.getText(), specializationField.getText(), Double.parseDouble(salaryField.getText()), behaviorField.getText()));
        } else if (e.getSource() == addPsychiatristButton) {
            addProfessional(new Psychiatrist(nameField.getText(), specializationField.getText(), Double.parseDouble(salaryField.getText()), prescriptionField.getText()));
        } else if (e.getSource() == addPsychologistButton) {
            addProfessional(new Psychologist(nameField.getText(), specializationField.getText(), Double.parseDouble(salaryField.getText()), phdField.getText()));
        } else if (e.getSource() == updateButton) {
            updateSpecialization(nameField.getText(), specializationField.getText());
        } else if (e.getSource() == removeButton) {
            removeProfessional(nameField.getText(), specializationField.getText(), salaryField.getText(), behaviorField.getText(), prescriptionField.getText(), phdField.getText());
        } 
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(MentalHealthCenterGUI::new);
    }
}
