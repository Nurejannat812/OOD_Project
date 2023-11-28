package outModule;

import mainModule.*;
import subModule.*;
import java.util.Scanner;

public class Main {
    public static void clearScreen() {
        System.out.print("\u001b[2J\u001b[H");
        System.out.flush();
    }

    public static void template(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                EverCare Hospital Limited System");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------\n");
    }
    public static void menu(){
        clearScreen();
        Scanner in = new Scanner(System.in);
        template();
        System.out.println("     1. Login");
        System.out.println("     2. Exit");
        System.out.print("\n     Chose a option: ");
        int option = in.nextInt();
        if(option == 1){
            clearScreen();
            template();
            System.out.println("     Login as:");
            System.out.println("        1. Admin\n" +
                               "        2. Community Doctor\n" +
                               "        3. Hospital Doctor\n");
            System.out.print("\n     Chose a option: ");
            int option1 = in.nextInt();

            if(option1 == 1){
                Admin admin = new Admin();
                admin.menu();
            }
            if(option1 == 2){

                System.out.print("\n     Enter community doctorId: ");
                int doctorId = in.nextInt();
                CommunityDoctor cd = CommunityDoctor.communityDoctor.get(doctorId);
                cd.menu();
            }
            if(option1 == 3) {
                System.out.print("\n     Enter hospital doctorId: ");
                int doctorId = in.nextInt();
                HospitalDoctor hd = HospitalDoctor.hospitalDoctor.get(doctorId);
                hd.menu();
            }
        }
        if(option == 2){
            clearScreen();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.println("                                           Thanks for using Ever Care Hospital Limited System");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------\n");
        }
    }
    public static void main(String[] args) {

      
        Patient.patient.add(new Patient("Nirob", "Gazipur", "03/05/2023", "01754567367"));

        HospitalDoctor.hospitalDoctor.add(new HospitalDoctor("Hasan", "Neuro", "015854964"));
     

        CommunityDoctor.communityDoctor.add(new CommunityDoctor("Nir", "57", "0158954"));
        //cd.showPatient();
        Diagnosis.diagnosis.add(new Diagnosis("CT Scan"));
        Medication.medication.add(new Medication("Paracitamol"));
        Medication.medication.add(new Medication("Cloron"));
        Surgery.surgery.add(new Surgery("General Surgery"));
        Surgery.surgery.add(new Surgery("CT Scan"));
        Surgery.surgery.add(new Surgery("Blood Test1"));

        Main.menu();
    }
}