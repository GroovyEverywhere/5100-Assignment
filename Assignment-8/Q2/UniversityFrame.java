package Assignment8;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


	class StudentsModel implements TableModel {

		private StudentsManager manager;

		public StudentsModel(StudentsManager manager) {
			this.manager = manager;
		}

		@Override
		public int getRowCount() {
			return manager.getStudentCount();
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return "Student id";
			}
			else if(columnIndex == 1) {
				return "Student name";
			}
			else {
				return "Student gender";
			}
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return String.class;
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {

			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Student s = manager.getStudents().get(rowIndex);
			if (columnIndex == 0) {
				return s.getId();
			} 
			else if(columnIndex == 1){
				return s.getName();
			}
			else {
				return s.getGender();
			}

		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub

		}

		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub

		}

		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub

		}

	}

	public class UniversityFrame extends BasicFrame {

		private JLabel studentIdLabel, nameLabel, genderLabel;
		private JTextField idText, nameText;
		private JComboBox genderBox;
		private JButton add, modify, delete, find;

		private JTable studentsTable;

		private StudentsModel model;
		private StudentsManager manager;

		@Override
		public void create() {
			
			studentIdLabel = new JLabel("Enter Student id : ");
			nameLabel = new JLabel("Enter Student Name : ");
			genderLabel = new JLabel("Choose student gender : ");
					
			idText = new JTextField(10);
			nameText = new JTextField(10);
			
			String[] gender = new String[]{"Male", "Female"}; 
	        genderBox = new JComboBox<String>(gender);

			add = new JButton("Add");
			
		     
			try {
				manager = new StudentsManagerFileImpl();
			} catch (Exception e) {
			}
			model = new StudentsModel(manager);
			studentsTable = new JTable(model);
		}

		@Override
		public void add(Container con) {
			addContent(con);
			con.add(new JScrollPane(studentsTable), "South");

		}
		
		public void addContent(Container con) {
			GridLayout bl = new GridLayout(4,1);
			con.setLayout(bl);
			addIdComponents(con);
	        addNameComponents(con);
	        addGenderComponents(con);
	        con.add(add);
		}
		
		private void addComponents(Container con, Component a, Component b) {
			JPanel panel = new JPanel();
			panel.add(a);
			panel.add(b);
			con.add(panel);

		}
		public void addIdComponents(Container con) {
			addComponents(con, studentIdLabel, idText );
		}
		public void addNameComponents(Container con) {
			addComponents(con, nameLabel, nameText );
		}
		public void addGenderComponents(Container con) {
			addComponents(con, genderLabel, genderBox );
		}

		
		public void addStudentInformation() {
			String id = idText.getText();
			String name = nameText.getText();
			String gender = genderBox.getSelectedItem().toString();
			try {
	            manager.addStudent(new Student(id, name, gender));
	        } catch (IllegalArgumentException e) {
	            JOptionPane.showMessageDialog(null, e.getMessage());
	        } catch (RuntimeException e) {
	            JOptionPane.showMessageDialog(null, e.getMessage());
	        }
		}

		@Override
		public void addListeners() {
			// TODO Auto-generated method stub
			add.addActionListener((e) -> addStudentInformation());
		}

		public static void main(String[] args) {
			new UniversityFrame();

		}

		
	}

