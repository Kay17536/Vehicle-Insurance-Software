import Plan.*;
import Policy.Customer;
import Policy.Policy;
import Policy.Vehicle;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
import java.util.List;

public class MainScreen extends JFrame {
    // Customization
    Font myFont = new Font("SansSerif", Font.BOLD,20);
    Color myColor = Color.GRAY;

    //Panel 1
    public static JTextField subName;
    public static JTextField subId;
    public static JTextField subCity;
    public static JTextField subPhone;

    //Panel 2
    JTextField model;
    JTextField manufacturer;
    JTextField plateNb;
    JTextField estimated;
    JRadioButton damageRadio1;
    JRadioButton damageRadio2;
    JRadioButton damageRadio3;
    JRadioButton damageRadio4;
    ButtonGroup G1;

    //Panel 3
    JCheckBox obligatoryCHKBX;
    JCheckBox allRiskCHKBX;
    JCheckBox vDamageCHKBX;
    JCheckBox dDamageCHKBX;
    JCheckBox assisCHKBX;
    List<String> coveredRisksList = new ArrayList<>();
    List<Float> premiumRisksList = new ArrayList<>();
    List<Float> coverageRisksList = new ArrayList<>();
    List<Float> ceilingRisksList = new ArrayList<>();


    //Panel4
    JRadioButton yearRadio;
    JRadioButton yearRadio2;
    JRadioButton yearRadio3;
    ButtonGroup G2;
    JLabel todayLBL;
    int validityYEAR = 0;
    SimpleDateFormat df;
    Date currentDate;

    //panel 5
    JTextArea risksTXT;
    JTextField searchTXT;
    Map<Integer, Customer> customerMap = new TreeMap<>();

    //panel 7
    JTextArea policyTXT;

    //panel 8
    JTextArea customerTXT;

    //panel 9
    JLabel claimingTXT;
    JLabel claimingTXT2;
    JTextField claimingCustomerField;

    //panel 10
    JLabel claimingCustomerNameLBL;
    JLabel claimStatusLBL2;
    JTextArea claimingCustomerRisksCoveredAREA;
    JLabel claimingCustomerValidDateLBL;
    boolean cond1;
    boolean cond2;
    boolean cond3;

    //Panel 11
    JTextArea settlementArea;
    float totalPremium = 0f;
    float totalCoverage = 0f;
    float totalCeiling = 0f;


    //Panel 12
    JTextArea settlementArea2;


    // Constructor
    public MainScreen(){
        CustomizePanel1();
        CustomizePanel2();
        CustomizePanel3();
        CustomizePanel4();
        CustomizePanel5();
        CustomizePanel6();
        CustomizePanel7();
        CustomizePanel8();
        CustomizePanel9();
        CustomizePanel10();
        CustomizePanel11();
        CustomizePanel12();
    }

    private void CustomizePanel1() {
        JPanel p1 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        " Customer ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        p1.setBorder(titledBorder);

        JLabel nameLBL = new JLabel("Full Name");
        JLabel idLBL = new JLabel("ID No");
        JLabel CityLBL = new JLabel("City");
        JLabel PhoneLBL = new JLabel("Phone");

        subName = new JTextField();        subName.setOpaque(false);
        subId = new JTextField();        subId.setOpaque(false);
        subCity = new JTextField();         subCity.setOpaque(false);
        subPhone = new JTextField();        subPhone.setOpaque(false);

        p1.add(nameLBL);
        p1.add(subName);
        p1.add(idLBL);
        p1.add(subId);
        p1.add(CityLBL);
        p1.add(subCity);
        p1.add(PhoneLBL);
        p1.add(subPhone);


        p1.setBounds(15,15,250,200);
        p1.setLayout(new GridLayout(4,2));

        //Adding panels to JFRAME
        setLayout(null);
        add(p1);
    }

    private void CustomizePanel2(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        " Vehicle ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p2 = new JPanel();
        p2.setBorder(titledBorder);

        //JLable p2
        JLabel plateNbLBL = new JLabel("Plate Number");
        JLabel modelLBL = new JLabel("Model Year");
        JLabel manufacturerLBL = new JLabel("Manufacturer");
        JLabel estimatedLBL = new JLabel("Estimated Value");
        JLabel spaceLBL = new JLabel(" ");
        JLabel damageLBL = new JLabel("Major Damage");

        //JTextfields
        plateNb = new JTextField();        plateNb.setOpaque(false);
        model = new JTextField();           model.setOpaque(false);
        manufacturer = new JTextField();        manufacturer.setOpaque(false);
        estimated= new JTextField();        estimated.setOpaque(false);

        //JRadiobuttons
        damageRadio1 = new JRadioButton();
        damageRadio1.setText("Motor");
        damageRadio2 = new JRadioButton();
        damageRadio2.setText("Wheels");
        damageRadio3 = new JRadioButton();
        damageRadio3.setText("Body");
        damageRadio4 = new JRadioButton();
        damageRadio4.setText("None");

        G1 = new ButtonGroup();
        G1.add(damageRadio1);
        G1.add(damageRadio2);
        G1.add(damageRadio3);
        G1.add(damageRadio4);

        // adding components to panel2
        p2.add(plateNbLBL);
        p2.add(plateNb);
        p2.add(modelLBL);
        p2.add(model);
        p2.add(manufacturerLBL);
        p2.add(manufacturer);
        p2.add(estimatedLBL);
        p2.add(estimated);
        p2.add(spaceLBL);
        p2.add(damageLBL);
        p2.add(damageRadio1);
        p2.add(damageRadio2);
        p2.add(damageRadio3);
        p2.add(damageRadio4);

        //Customize panel2
        p2.setBounds(15,250,250,450);
        p2.setLayout(new GridLayout(14,1));

        add(p2);
    }

    private void CustomizePanel3(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        " Customer ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);
        JPanel p3 = new JPanel();
        p3.setBorder(titledBorder);
        p3.setBounds(300,15,250,200);
        p3.setLayout(new GridLayout(6,1));

        JLabel packageLBL = new JLabel("Please select your plan");

        // Checkbox
        obligatoryCHKBX = new JCheckBox("Obligatory");
        allRiskCHKBX = new JCheckBox("All Risks");
        vDamageCHKBX = new JCheckBox("Vehicle Damage");
        dDamageCHKBX = new JCheckBox("Driver Damage");
        assisCHKBX = new JCheckBox("Assistance");

        //GET all risks covered by plan
        GetRisksCoveredByPlan();


        // Adding components to panel3
        p3.add(packageLBL);
        p3.add(obligatoryCHKBX);
        p3.add(allRiskCHKBX);
        p3.add(vDamageCHKBX);
        p3.add(dDamageCHKBX);
        p3.add(assisCHKBX);

        add(p3);

    }

    private void CustomizePanel4(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        " Validity Period ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p4 = new JPanel();
        p4.setBorder(titledBorder);
        p4.setBounds(300,250,250,250);
        p4.setLayout(new GridLayout(6,1));

        //Radio buttons
        JLabel spacer2 = new JLabel("");      spacer2.setOpaque(false);
        yearRadio = new JRadioButton();
        yearRadio.setText(" 1 Year");
        yearRadio2 = new JRadioButton();
        yearRadio2.setText(" 2 Years");
        yearRadio3 = new JRadioButton();
        yearRadio3.setText(" 3 Years");

        yearRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYEAR = 1;
            }
        });
        yearRadio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYEAR = 2;
            }
        });
        yearRadio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYEAR = 3;
            }
        });

        //Button Group

        G2 = new ButtonGroup();
        G2.add(yearRadio);
        G2.add(yearRadio2);
        G2.add(yearRadio3);


        //Time & Date
        todayLBL = new JLabel();
        df = new SimpleDateFormat("dd/MM/yyyy");
        currentDate = new Date();
        todayLBL.setText("Today: " + df.format(currentDate));
        todayLBL.setOpaque(false);

        Font font = todayLBL.getFont();
        float size = font.getSize() + 3.0f;
        todayLBL.setFont( font.deriveFont(size));

        //Adding all components to panel4
        p4.add(spacer2);
        p4.add(spacer2);
        p4.add(todayLBL);
        p4.add(spacer2);
        p4.add(yearRadio);
        p4.add(yearRadio2);
        p4.add(yearRadio3);

        //Adding panel4 to JFrame
        add(p4);


    }

    private void CustomizePanel5(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        " Actions ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);
        JPanel p5 = new JPanel();
        p5.setBounds(300,500,250,230);
        p5.setBorder(titledBorder);
        p5.setLayout(new GridLayout(7,1));

        JButton saveBTN = new JButton("Save Customer");
        JButton showBTN = new JButton("Show plan details");
        JButton loadBTN = new JButton("Load Customer");
        JButton newBTN = new JButton("New Customer");

        searchTXT = new JTextField("Enter the car plate number");
        searchTXT.setOpaque(false);

        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String str = "";
                for (int i = 0; i< coveredRisksList.size();i++){
                    str += coveredRisksList.get(i) + "\n";
                }
                risksTXT.setText(str);

                try {
                    policyTXT.setText(GetPolicyData().toString());
                    DisplayPaymentsOfPolicy();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                // Add here the code to be executed
            }
        });

        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //SaveCustomerMapToDisk();
                    saveDetails();
                } finally {

                }



                //catch (IOException ex) {                    throw new RuntimeException(ex);}
                //catch (ParseException ex) {   throw new RuntimeException(ex);              }
               //catch (ClassNotFoundException ex) { throw new RuntimeException(ex); }

            }
        });

        JLabel spacer3 = new JLabel(" ");
        spacer3.setOpaque(false);

        loadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchDetails();
            }
        });

        JLabel spacer4 = new JLabel(" ");
        spacer4.setOpaque(false);
        JLabel spacer5 = new JLabel(" ");
        spacer5.setOpaque(false);
        JLabel spacer6 = new JLabel(" ");
        spacer6.setOpaque(false);

        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewCustomer();

            }
        });

        p5.add(spacer6);
        p5.add(showBTN);
        p5.add(saveBTN);
        p5.add(newBTN);
        p5.add(spacer5);
        p5.add(searchTXT);
        p5.add(loadBTN);

        add(p5);
    }

    private void CustomizePanel6(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        " Covered Risks ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);
        JPanel p6 = new JPanel();
        p6.setBorder(titledBorder);
        p6.setBounds(575,15,250,200);

        risksTXT = new JTextArea(7,1);
        risksTXT.setEditable(false);
        risksTXT.setOpaque(false);
        risksTXT.setLineWrap(true);

        // Font
        Font font = risksTXT.getFont();
        float size = font.getSize() + 3.0f;
        risksTXT.setFont(font.deriveFont(size));

        p6.add(risksTXT);

        p6.setLayout(new GridLayout(1,1));
        add(p6); //adding p6 to jframe
    }

    private void CustomizePanel7(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        " Policy Details ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);
        JPanel p7 = new JPanel();
        p7.setBounds(575,250,250,250);
        p7.setBorder(titledBorder);
        p7.setLayout(new GridLayout(6,1));

        policyTXT = new JTextArea(20,1);
        policyTXT.setEditable(false);
        policyTXT.setOpaque(false);
        policyTXT.setLineWrap(true);

        Font font = policyTXT.getFont();
        float size = font.getSize() + 3.0f;
        policyTXT.setFont(font.deriveFont(size));

        p7.add(policyTXT);
        p7.setLayout(new GridLayout(1,1));
        add(p7); //adding jpanel7 to jframe
    }

    private void CustomizePanel8(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        " Customer Details ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);
        JPanel p8 = new JPanel();
        p8.setBorder(titledBorder);
        p8.setBounds(575,520,250,200);
        p8.setLayout(new GridLayout(6,1));


        customerTXT = new JTextArea(20,1);
        customerTXT.setEditable(false);
        customerTXT.setOpaque(false);
        customerTXT.setLineWrap(true);

        //increase the size of the font for the jtextarea
        Font font = customerTXT.getFont();
        float size = font.getSize() + 3.0f;
        customerTXT.setFont(font.deriveFont(size));

        p8.add(customerTXT);
        p8.setLayout(new GridLayout(1,1));
        add(p8);

    }
    String[] items = {"Fire",
            "Robbery",
            "Third Party Damage",
            "Vehicle Damage",
            "Driver Damage",
            "Transport",
            "Car replacement"};

    final JList claimList = new JList(items);

    private void CustomizePanel9(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        " Claims ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);
        JPanel p9 = new JPanel();
        p9.setBorder(titledBorder);
        p9.setBounds(850,15,280,485);

        claimingTXT = new JLabel("Enter the plate number for the Claiming Customer");
        JLabel spacer99 = new JLabel("                                                     ");
        claimingTXT2 = new JLabel("Select the type of damage or Assistance Needed");

        claimingCustomerField = new JTextField();
        claimingCustomerField.setPreferredSize(new Dimension(250,30));
        claimingCustomerField.setOpaque(false);



        claimList.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        claimList.setOpaque(false);

        claimList.setPreferredSize(new Dimension(250,150));

        JButton searchClaimer = new JButton("Search Customer");
        List<String> coveredRisksByUserLIST = new ArrayList<>();
        searchClaimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cond1 = false;   // customer is registered before in our db??
                cond2 = false;      // Is the customer's policy cover the claimed risk?
                cond3 = false;      //Is the policy date valid?

                try{
                    coveredRisksByUserLIST.clear();
                    customer1 = searchClaimsDetails();
                    claimingCustomerNameLBL.setText("Claiming Customer : "+ customer1.getname());
                    cond1 =true;

                    String str7 = "";
                    for (int i = 0;i<customer1.getPolicy().getRisksCoveredLIST().size();i++){
                        str7 += customer1.getPolicy().getRisksCoveredLIST().get(i) + " \n";
                        coveredRisksByUserLIST.add(customer1.getPolicy().getRisksCoveredLIST().get(i));
                    }

                    LocalDate v_validityofPolicy = customer1.getPolicy().getPolicyDate();
                    int v_policyVaslidityYears = customer1.getPolicy().getValidityYear();
                    v_validityofPolicy = v_validityofPolicy.plusYears(v_policyVaslidityYears);

                    CheckPolicyValidity(v_validityofPolicy);

                    claimingCustomerRisksCoveredAREA.setText("Covered Risks By Customer Plan: \n"+str7);
                    claimingCustomerValidDateLBL.setText("Date Validity Of Policy: " + v_validityofPolicy+ "  ||  " + CheckPolicyValidity(v_validityofPolicy));

                    if (customer1.getPolicy().getRisksCoveredLIST().size() >=5){
                        // if the user has all risk plan
                        cond2 = true;

                    }


                }catch (Exception re){
                    claimingCustomerNameLBL.setText("Claiming Customer : Not Found");
                }

            }
        });

        JButton confirmClaimBTN = new JButton("   Confirm Claim");
        confirmClaimBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the index of ll the selected items
                int[] selectedIx = claimList.getSelectedIndices();
                List<String> claimed_list = new ArrayList<>();

                if (claimList.getSelectedIndex() != -1){
                    for (int i=0;i<selectedIx.length;i++){
                        String k = "" + claimList.getModel().getElementAt(selectedIx[i]) + " ";
                        claimed_list.add(""+claimList.getModel().getElementAt(selectedIx[i]));
                        System.out.print("" + k);
                    }
                }

                //check for the included risks??
                if(cond2 == false){
                    cond2 = claimed_list.containsAll(coveredRisksByUserLIST);
                }

                //check for claim validity to add the claim to the customer,
                // claims map on other file file2
                ClaimIsValid();

                //Display settlements
                Customer c = searchClaimsDetails();
                if (ClaimIsValid()){
                    int claims_nb = claimed_list.size();
                    if(claimed_list.contains("Fire")){
                       settlementArea2.setText("Fire Department: "+
                                c.getPolicy().getVehicle().getEstimatedValue()*0.25 + " Kshs");
                    }else if(claimed_list.contains("Robbery")){
                        settlementArea2.setText("ProSec Company: "+
                                c.getPolicy().getVehicle().getEstimatedValue()*0.5 + " Kshs" +
                                "Pay for Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*1 + " Kshs ");
                    }else if(claimed_list.contains("Third Party Damage")){
                        settlementArea2.setText("Driver In The Other Car: "+ 2000 + " Kshs");
                    }else if(claimed_list.contains("Vehicle Damage")) {
                        settlementArea2.setText("Pay For Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*1+ " Kshs ");
                    }else if(claimed_list.contains("Driver Damage")){
                        settlementArea2.setText("Pay For Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*10+ " Kshs ");
                    }else if(claimed_list.contains("Transport")){
                        settlementArea2.setText("Transport Company: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.5+ " Kshs ");
                    }else if(claimed_list.contains("Car Replacement")){
                        settlementArea2.setText("Car Rental Company: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.2+ " Kshs ");
                    } else if (claims_nb > 2) {
                        settlementArea2.setText("Driver "
                                + c.getPolicy().getVehicle().getEstimatedValue()*4
                                + " Kshs " +
                                "Car Rental Company: "
                                + c.getPolicy().getVehicle().getEstimatedValue()*0.2 +
                                " Kshs "+
                                "Third Party Driver"+
                                c.getPolicy().getVehicle().getEstimatedValue()*2);

                    }else {

                    }

                }

            }
        });
        p9.add(claimingTXT);
        p9.add(claimingCustomerField);
        p9.add(searchClaimer);
        p9.add(spacer99);
        p9.add(claimingTXT2);
        p9.add(claimList);
        p9.add(confirmClaimBTN);

        add(p9);
    }

    private void CustomizePanel10(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        " Claim Status ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p10 = new JPanel();
        p10.setBorder(titledBorder);
        p10.setBounds(850,520,250,200);
        p10.setLayout(new GridLayout(4,1));

        //Jlabels
        claimingCustomerNameLBL = new JLabel("Claiming Customer: ");
        claimingCustomerValidDateLBL = new JLabel("Date Validity of Policy: ");
        claimStatusLBL2 = new JLabel("Claiming Status: ");

        //JTextArea
        claimingCustomerRisksCoveredAREA = new JTextArea();
        JScrollPane pictureScrollPane = new JScrollPane(claimingCustomerRisksCoveredAREA);
        claimingCustomerRisksCoveredAREA.setOpaque(false);


        p10.add(claimingCustomerNameLBL);
        p10.add(claimingCustomerValidDateLBL);
        p10.add(pictureScrollPane);
        p10.add(claimStatusLBL2);

        add(p10);
    }

    private void CustomizePanel11(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        " Payments ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p11 = new JPanel();
        p11.setBorder(titledBorder);
        p11.setBounds(1150,15,250,230);
        p11.setLayout(new GridLayout(2,1));

        settlementArea = new JTextArea();
        settlementArea.setOpaque(false);

        //Increasing the size of JTextarea
        Font font = customerTXT.getFont();
        float size = font.getSize() + 4.0f;
        customerTXT.setFont(font.deriveFont(size));

        p11.add(settlementArea);
        add(p11);
    }

    private void CustomizePanel12(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.gray,1),
                        " Settlements ", TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        myFont,myColor);

        JPanel p12 = new JPanel();
        p12.setBorder(titledBorder);
        p12.setBounds(1150,250,250,450);
        p12.setLayout(new GridLayout());




        settlementArea2 = new JTextArea();
        settlementArea2.setOpaque(false);
        p12.add(settlementArea2);

        Font font = settlementArea2.getFont();
        float size = font.getSize() + 4.0f;

        add(p12);
    }


    /*******************************  Methods  **************************/


    //Get customer Data

    public Customer GetCustomerData() throws ParseException {
        Customer customer = new Customer(
                subName.getText(),
                Integer.parseInt(subId.getText()),
                subCity.getText(),
                Integer.parseInt(subPhone.getText()),
                GetPolicyData()
        );
        return customer;

    }


    // Vehicle Data
    public Vehicle GetVehicleData() throws ParseException{
        Vehicle vehicle = new Vehicle(
                plateNb.getText(),
                Integer.parseInt(model.getText()),
                manufacturer.getText(),
                Integer.parseInt(estimated.getText()),
                GetDamageState()
        );
        return vehicle;
    }

    //Get policyData()
    public Policy GetPolicyData() throws  ParseException{
        currentDate = new Date();

        LocalDate now = LocalDate.now();
        Policy policy = new Policy(
                GetVehicleData(),
                coveredRisksList,
                premiumRisksList,
                coverageRisksList,
                ceilingRisksList,
                validityYEAR,
                now );
        return policy;

    };

    //Get Damage Data
    public String GetDamageState(){

        if (damageRadio1.isSelected()){
            return "Motor";
        } else if (damageRadio2.isSelected()) {
            return "Wheels";
        } else if (damageRadio3.isSelected()) {
            return "Body";
        }else
            return "No Damage";
    };
    public String GetPlan(){
        if (allRiskCHKBX.isSelected()){
            return "All Risk";
        } else if (vDamageCHKBX.isSelected()) {
            return "Vehicle Damage";
        } else if (assisCHKBX.isSelected()) {
            return "Assistance Damge";
        }else
            return "Obligatory Damage";

    }

    //get plan details
    public void GetRisksCoveredByPlan(){
        AllRisk allRisk = new AllRisk();
        ObligatoryRisk obligatoryRisk = new ObligatoryRisk();
        allRiskCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dDamageCHKBX.setEnabled(false);
                vDamageCHKBX.setEnabled(false);
                assisCHKBX.setEnabled(false);
                obligatoryCHKBX.setEnabled(false);

                //adding risk details to an array
                for (int i=0;i<allRisk.allRisksCovered.length;i++){
                    coveredRisksList.add(allRisk.allRisksCovered[i]);
                }
                premiumRisksList.add(allRisk.getPremium());
                coverageRisksList.add(allRisk.getCoverage());
                ceilingRisksList.add(allRisk.getCeiling());
            }
        });

        obligatoryCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //adding risk details to ana array

                coveredRisksList.add(allRisk.allRisksCovered[0]);
                premiumRisksList.add(allRisk.getPremium());
                coverageRisksList.add(allRisk.getCoverage());
                ceilingRisksList.add(allRisk.getCeiling());
            }
        });

        vDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehicleRisk vehicleRisk = new VehicleRisk();

                //adding risk to arrays

                coveredRisksList.add(vehicleRisk.vehicleRisksCovered[0]);
                premiumRisksList.add(vehicleRisk.getPremium());
                coverageRisksList.add(vehicleRisk.getCoverage());
                ceilingRisksList.add(vehicleRisk.getCeiling());

            }
        });

        dDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriverRisk driverRisk = new DriverRisk();

                coveredRisksList.add(driverRisk.driverRisksCovered[0]);
                premiumRisksList.add(driverRisk.getPremium());
                coverageRisksList.add(driverRisk.getCoverage());
                ceilingRisksList.add(driverRisk.getCeiling());

            }
        });
        assisCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssistanceRisk assistanceRisk = new AssistanceRisk();

                //adding risk details to array

                for (int i=0;i<assistanceRisk.assistanceRisksCovered.length;i++){
                    coveredRisksList.add(assistanceRisk.assistanceRisksCovered[i]);
                }
                premiumRisksList.add(assistanceRisk.getPremium());
                coverageRisksList.add(assistanceRisk.getCoverage());
                ceilingRisksList.add(assistanceRisk.getCeiling());

            }
        });

    }


    //save data to disk

    /*public  void SaveCustomerMapToDisk() throws IOException, ClassNotFoundException, ParseException {
        File file = new File("D:/myfile.dat");
        int platenbmr = Integer.parseInt(plateNb.getText());

        if (!file.exists()) {
            //creating a new file
            System.out.println("Not Existed");
            file.createNewFile();

            SaveCustomerMaptoNewFile(platenbmr, file);
        } else {
            //file exists
            TreeMap<Integer, Customer> newMaptoSave = new TreeMap<>();
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer, Customer>) ois.readObject();
            ois.close();
            is.close();


            //Get old map
            for(Map.Entry<Integer, Customer> m : mapInFile.entrySet())
            {
                newMaptoSave.put(m.getKey(), m.getValue());
            }
            //updating the map: adding new customer to map
            newMaptoSave.put(platenbmr, GetCustomerData());

            //saving the updates to file
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(newMaptoSave);
            oos.flush();
            oos.close();


        }

    }*/

    /*private void SaveCustomerMaptoNewFile(int platenbmr, File file) throws ParseException, IOException {

        TreeMap<Integer, Customer> newMaptoSave = new TreeMap<>();

        //Adding new Customer to map
        newMaptoSave.put(platenbmr,GetCustomerData());

        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(newMaptoSave);
        oos.flush();
        oos.close();
    }

    // Resettig Fields to empty */
    private void NewCustomer(){
        coverageRisksList.clear();
        coveredRisksList.clear();
        premiumRisksList.clear();
        ceilingRisksList.clear();
        risksTXT.setText("");
        policyTXT.setText("");
        cond1 = false;
        cond2 = false;
        cond3 = false;

        //set fields to empty
        subName.setText("");
        subId.setText("");
        subCity.setText("");
        subPhone.setText("");
        plateNb.setText("");
        model.setText("");
        manufacturer.setText("");
        estimated.setText("");

        //set radiobuttons selection to none
        G1.clearSelection();
        G2.clearSelection();

        //reset checkbox
        obligatoryCHKBX.setSelected(false);
        allRiskCHKBX.setSelected(false);
        vDamageCHKBX.setSelected(false);
        dDamageCHKBX.setSelected(false);
        assisCHKBX.setSelected(false);

        dDamageCHKBX.setEnabled(true);
        vDamageCHKBX.setEnabled(true);
        assisCHKBX.setEnabled(true);
        obligatoryCHKBX.setEnabled(true);





    }


    private boolean CheckPolicyValidity(LocalDate v_validityofPolicy){
        LocalDate now = LocalDate.now();

        if( now.isBefore(v_validityofPolicy)){
            cond3 = true;
            return true;
        }else{
            cond3 = false;
            return false;
        }
    }

    private  boolean ClaimIsValid(){
        if(cond1 && cond2 && cond3){
            claimStatusLBL2.setText("Claiming Status: You Can Register The Claim");
            return true;
        }else{
            claimStatusLBL2.setText("Claiming Status: Not Able To Register The Claim");
            return false;
        }
    }

    private void DisplayPaymentsOfPolicy(){

        for(int i = 0; i< premiumRisksList.size();i++){
            totalPremium += premiumRisksList.get(i);
            totalCoverage += premiumRisksList.get(i);
            totalCeiling += premiumRisksList.get(i);
        }
        settlementArea.setText(
                "Total Premium :" + totalPremium* Integer.parseInt(estimated.getText()) + " Kshs \n"+
                        "Risks Coverage : " + totalCoverage*Integer.parseInt(estimated.getText())* 10 + " Kshs \n"+
                        "max Ceiling : " + totalCeiling*Integer.parseInt(estimated.getText()) + 100000 + " Kshs \n"
        );

    }
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String databaseusrl = "jdbc:mysql://localhost/vehicle insurance management system";
    public static String username = "root";
    public static String password = "";
    public static Connection conn;

    public static Connection getConnection() {
        try {

            Class.forName(driver);
            conn = DriverManager.getConnection(databaseusrl, username, password);
            System.out.println("Database connected");

            return conn;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public Customer customer;

    public void saveDetails(){
        Customer customer = null;
        getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO customer (Name, ID, City, Phone, Plate_Number) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,subName.getText());
            preparedStatement.setInt(2, Integer.parseInt((subId.getText())));
            preparedStatement.setString(3,subCity.getText());
            preparedStatement.setInt(4, Integer.parseInt(subPhone.getText()));
            preparedStatement.setString(5,plateNb.getText());

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Number of affected rows: " + affectedRows);
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO vehicledetails (Plate_Number, Manufacture_Year, Manufacturer, Estimated_Value, Damage) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,plateNb.getText());
            preparedStatement.setInt(2, Integer.parseInt((model.getText())));
            preparedStatement.setString(3,manufacturer.getText());
            preparedStatement.setInt(4, Integer.parseInt(estimated.getText()));
            preparedStatement.setString(5,GetDamageState());

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Number of affected rows: " + affectedRows);
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO insuranceplan (Plate_Number, Plan, Risks, Validity_Period, Premium_Cost, Coverage_Cost, Ceiling_Cost) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);


            preparedStatement.setString(1,plateNb.getText());
            preparedStatement.setString(2, GetPlan());
            preparedStatement.setString(3, String.valueOf(coveredRisksList));
            preparedStatement.setInt(4, validityYEAR);
            preparedStatement.setFloat(5, totalPremium* Integer.parseInt(estimated.getText()));
            preparedStatement.setFloat(6, totalCoverage*Integer.parseInt(estimated.getText())* 10);
            preparedStatement.setFloat(7, totalCeiling*Integer.parseInt(estimated.getText()) + 100000);

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Number of affected rows: " + affectedRows);
        }catch (Exception e){
            System.out.println(e);
        }
        ClaimIsValid();
        
        /*try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO claims (Plate_Number, Assistance_Needed) VALUES (?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,plateNb.getText());

            preparedStatement.setString(2, (String) claimList.getSelectedValue());


            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Number of affected rows: " + affectedRows);
        }catch (Exception e){
            System.out.println(e);
        }*/
    }
    public void searchDetails(){
        Customer customer = new Customer();



        try {
            getConnection();
            Statement stmt = conn.createStatement();
            String plateNumber = searchTXT.getText();

            String query = "SELECT Name, ID, City, Phone FROM customer WHERE Plate_Number = '" + plateNumber + "'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Customer.name = rs.getString(1);
                Customer.nId = rs.getInt(2);
                Customer.city = rs.getString(3);
                Customer.c_phone = rs.getInt(4);

                customerTXT.setText(customer.toString());
            }

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }



    }
    Customer customer1 = new Customer();
    public Customer searchClaimsDetails() {
          // Instantiate a new Customer object

        try {
            getConnection();
            Statement stmt = conn.createStatement();
            String plateNumber = claimingCustomerField.getText();

            String query = "SELECT customer.Plate_Number, customer.Name, insuranceplan.Risks, insuranceplan.Validity_Period FROM customer INNER JOIN insuranceplan ON customer.Plate_Number = insuranceplan.Plate_Number WHERE customer.Plate_Number = '" + plateNumber + "'";
            ResultSet rs = stmt.executeQuery(query);


            while (rs.next()) {
                Vehicle.plateNb = rs.getString(1);
                Customer.name = rs.getString(2);

                Customer.setName(rs.getString("Name"));
                //claimingCustomerNameLBL.setText("Claiming Customer: " + Customer.name);
                // Set other customer attributes as needed
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer1;
    }
   /*private void SearchCustomerByMobileNB(){
        Customer c_finded = new Customer();
        File file = new File("D:/myfile.dat");

        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Customer> mapInFile =  (TreeMap<Integer, Customer>)ois.readObject();

            ois.close();
            is.close();

            c_finded = mapInFile.get(Integer.parseInt(searchTXT.getText()));
            customerTXT.setText(c_finded.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }*/
   /*private Customer ClaimsSearchCustomerByMobileNb(){
       Customer customer = new Customer();
       File file = new File("D:/myfile.dat");

       try {
           InputStream is = new FileInputStream(file);
           ObjectInputStream ois = new ObjectInputStream(is);
           TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer, Customer>) ois.readObject();

           ois.close();
           is.close();

           customer = mapInFile.get(Integer.parseInt(claimingCustomerField.getText()));

       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }

       return customer;

   } */






    public static void main(String[] args){
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setTitle("Insurance Company System");
        mainScreen.setBounds(0,0,1920,1080);
        getConnection();


    }
}