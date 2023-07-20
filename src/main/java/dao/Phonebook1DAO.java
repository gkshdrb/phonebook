package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.stereotype.Repository;


import vo.PhonebookVO;
@Repository
public class Phonebook1DAO implements PhonebookDAO{

	Connection conn;
	
	
	public Phonebook1DAO() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(PhonebookVO pb) {
		try {
			String sql="insert into phonebook values(phonebook_idx_seq.nextval,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,pb.getHp());
			ps.setString(2,pb.getName());
			ps.setString(3, pb.getMemo());
			int result=ps.executeUpdate();
			ps.close();
			return result;
			}catch(Exception e) {
		e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<PhonebookVO> findAll() {
		try {
			String sql="select * from phonebook";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			List<PhonebookVO> list=new ArrayList<PhonebookVO>();
			while(rs.next()) {
				list.add(new PhonebookVO(rs.getInt("idx"),rs.getString("hp"),rs.getString("name"),rs.getString("memo")));
			}
			rs.close();
			ps.close();
		
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PhonebookVO> searchFind(String search) {
		List<PhonebookVO> resultList = new ArrayList<>();
	    int idx = 0;
		try {
            String sql = "select * from phonebook_table where idx = ? or hp = ? or name = ? or memo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, search);
            ps.setString(2, search);
            ps.setString(3, search);
            ps.setString(4, search);

            ResultSet rs=ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idx");
                String hp = rs.getString("hp");
                String name = rs.getString("name");
                String memo = rs.getString("memo");

                PhonebookVO phonebookVO = new PhonebookVO(idx, hp, name, memo);
                resultList.add(phonebookVO);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
	

	@Override
	public PhonebookVO findOneById(int idx) {
		try {
			String sql="select * from phonebook where idx=1";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, idx);
			ResultSet rs=ps.executeQuery();
			PhonebookVO phonebook=null;
			if(rs.next()) {
				String hp=rs.getString("hp");
				String name=rs.getString("name");
				String memo=rs.getString("memo");
				phonebook=new PhonebookVO(idx, hp, name, memo);
				System.out.println(phonebook.toString());
			}
			rs.close();
			ps.close();
			return phonebook;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int update(int idx, PhonebookVO pb) {
		try {
			String sql="update phonebook set hp=?, name=?, memo=? where idx=1";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,pb.getHp());
			ps.setString(2,pb.getName());
			ps.setString(3, pb.getMemo());
			ps.setInt(4, pb.getIdx());
			int result=ps.executeUpdate();
			ps.close();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int idx) {
		try {
			String sql="delete from phonebook where idx=1";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, idx);
			int result=ps.executeUpdate();
			ps.close();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
