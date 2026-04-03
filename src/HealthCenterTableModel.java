import java.util.*;
import javax.swing.table.AbstractTableModel;

public class HealthCenterTableModel extends AbstractTableModel{

    private String[] columnNames = {"Name", "Surname", "Date of Birth", "Phone No", "Staff ID", "Role"};
    private ArrayList<StaffMember> StaffMemberList;

    public HealthCenterTableModel(ArrayList<StaffMember> StaffMemberList) {
        this.StaffMemberList = StaffMemberList;
    }

    @Override
    public int getRowCount(){
        return StaffMemberList == null ? 0 : StaffMemberList.size();
    }

    @Override
    public int getColumnCount(){
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Object temp = null;

        if(columnIndex == 0) {
            temp = StaffMemberList.get(rowIndex).getName();
        }
        if(columnIndex == 1) {
            temp = StaffMemberList.get(rowIndex).getSurname();
        }
        if(columnIndex == 2) {
            temp = StaffMemberList.get(rowIndex).getDob();
        }
        if(columnIndex == 3) {
            temp = StaffMemberList.get(rowIndex).getPhoneNo();
        }
        if(columnIndex == 4) {
            temp = StaffMemberList.get(rowIndex).getStaffID();
        }
        if(columnIndex == 5) {
            if(StaffMemberList.get(rowIndex) instanceof Doctor) {
                temp = "Doctor";
            } else if(StaffMemberList.get(rowIndex) instanceof Receptionist) {
                temp = "Receptionist";
            }
        }
        return temp;
    }

    @Override
    public String getColumnName(int col) {return columnNames[col];}
}
