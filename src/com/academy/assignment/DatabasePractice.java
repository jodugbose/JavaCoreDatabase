package com.academy.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabasePractice {

    static final String DB_URL = "jdbc:sqlserver://;servername=ISW-211201-256;database=Training;instanceName=SQLEXPRESS;encrypt=false;integratedSecurity=true";
    public static void DynamicTableCreation(){

        try(Connection conn = DriverManager.getConnection(DB_URL);
            Scanner ScanInput = new Scanner(System.in)){

            System.out.println("Enter your table name: ");
            String tableName = ScanInput.nextLine();

            List<String> columnNames = new ArrayList<>();
            List<String> dataTypes = new ArrayList<>();


            //Get column details from user
            while (true) {
                System.out.print("Enter your column names or (done to finish) ");
                String columnName = ScanInput.nextLine();
                if (columnName.equalsIgnoreCase("done")) {
                    break;

                }
                columnNames.add(columnName);

                System.out.print("Enter the datatype of  " + columnName + "': ");
                String dataType = ScanInput.nextLine();
                dataTypes.add(dataType);

            }

            //Create your SQL QUERY

            StringBuilder sql =new StringBuilder ("CREATE TABLE  " + tableName + " (");
            for(int i = 0; i < columnNames.size();i++){
            String columnName = columnNames.get(i);
            String dataType = dataTypes.get(i);
                sql.append(columnName).append(" ").append(dataType);
                if (i < columnNames.size() - 1){
                    sql.append(", ");
                }


            }
            sql.append(")");

            try(Statement stmt = conn.createStatement()){
                stmt.executeUpdate(sql.toString());
                System.out.println("Table Created Successfully");
            }catch (Exception e){
                e.printStackTrace();
            }




        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
