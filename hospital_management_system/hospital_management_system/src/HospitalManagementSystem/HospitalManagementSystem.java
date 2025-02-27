package HospitalManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class HospitalManagementSystem {

    private static final String url="jdbc:mysql://localhost:3306/hospital";

    private static final String username="root";

    private static final String password="admin";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Patient patient = new Patient(connection,scanner);
            Doctor doctor = new Doctor(connection);

            while (true){
                System.out.println(" HOSPITAL MANAGEMENT SYSTEM ");
                System.out.println("1, Add Patients");
                System.out.println("2, View Patients");
                System.out.println("3, View Doctors");
                System.out.println("4, Book Doctors");
                System.out.println("5, check appointment list");
                System.out.println("6, Exit");
                System.out.println("enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        patient.addPatient();
                        System.out.println();
                        break;
                    case 2:
                        patient.viewPatient();
                        System.out.println();
                        break;
                    case 3:
                        doctor.viewDoctors();
                        System.out.println();
                        break;
                    case 4:
                        bookAppointment(patient,doctor,connection,scanner);
                        System.out.println();
                        break;
                    case 5:
                        doctor.viewAppointments();
                        System.out.println();

                    case 6:
                        return;

                    default:
                        System.out.println("enter valid choice");
                        break;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void bookAppointment(Patient patient,Doctor doctor,Connection connection,Scanner scanner){
        System.out.println("enter patient id: ");
        int patientId=scanner.nextInt();
        System.out.println("enter doctor id: ");
        int doctorId =scanner.nextInt();
        System.out.println("enter appointment date (yyyy-mm-dd)");
        String appointmentDate=scanner.next();
        if(patient.getPatientById(patientId) && doctor.getDoctorById(doctorId)){
            if(checkDoctorAvailability(doctorId,appointmentDate,connection)){
                String appointmentQuery="insert into appointments(patient_id,doctor_id,appointment_date) values(? , ? , ?)";

                try{
                    PreparedStatement preparedStatement =connection.prepareStatement(appointmentQuery);
                    preparedStatement.setInt(1,patientId);
                    preparedStatement.setInt(2,doctorId);
                    preparedStatement.setString(3,appointmentDate);
                    int rowsAffected= preparedStatement.executeUpdate();
                    if(rowsAffected>0){
                        System.out.println("Appointment Booked");
                    }else {
                        System.out.println("Failed to Book Appointment!");
                    }
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }else {
                System.out.println("doctor not available on this date");
            }
        }else {
            System.out.println("either doctor or patient doesn't exist");
        }

    }

    public static boolean checkDoctorAvailability(int doctorId,String appointmentDate, Connection connection){
        String query = "select count(*) from appointments where doctor_id = ? and appointment_date = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,doctorId);
            preparedStatement.setString(2,appointmentDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int count = resultSet.getInt(1);
                if(count==0){
                    return true;
                }else {
                    return false;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();

        }
        return false;
    }
}
