package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Doctor {
    private Connection connection;



    public  Doctor(Connection connection){

        this.connection= connection;



    }



    public void viewDoctors(){
        String query = "select * from doctors";

        try{
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet =preparedStatement.executeQuery();
            System.out.println("Doctors: ");
            System.out.println("+------------+-------------------------+---------------------+");
            System.out.println("| Doctor Id  | Name                    | Specialization      |");
            System.out.println("+------------+-------------------------+---------------------+");
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String specialization=resultSet.getString("specialization");
                System.out.printf("| %-11s | %-24s | %-20s |\n",id,name,specialization);
                System.out.println("+------------+-------------------------+---------------------+");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void viewAppointments(){
        String query = "select * from appointments";

        try{
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet =preparedStatement.executeQuery();
            System.out.println("Appointments: ");
            System.out.println("+-----------------+------------+-----------+--------------------+");
            System.out.println("| Appointment Id  | Patient Id | Doctor Id |  Appointment Date  |");
            System.out.println("+-----------------+------------+-----------+--------------------+");
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                int pid=resultSet.getInt("patient_id");
                int did=resultSet.getInt("doctor_id");
                Date adate=resultSet.getDate("appointment_date");

                System.out.printf("| %-16s| %-11s| %-10s| %-19s|\n",id,pid,did,adate);
                System.out.println("+-----------------+------------+-----------+--------------------+");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public boolean getDoctorById(int id){
        String query="select * from doctors where id=?";

        try{
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else {
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();;
        }
        return false;
    }
}
