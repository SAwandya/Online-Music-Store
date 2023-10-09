package com.musicshop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MusicDBUtil {
		
		private static boolean isSuccess;
		private static Connection con = null;
		private static Statement stmt = null;
		private static ResultSet rs = null;
		
		
		public static boolean insertSong(String name, String path, String fileName, int cid, int aid, String description) {
			
			boolean isSuccess = false;
			
			try {
		        con = DBConnect.getConnection();
		        stmt = con.createStatement();
		        
		        String sql = "INSERT INTO songs VALUES (0,'" + name + "', '" + path + "', '" + fileName + "', " + cid + ", " + aid + ", '"+description+"')";
		        
		        int rs = stmt.executeUpdate(sql);
		        
		        if (rs > 0) {
		            isSuccess = true;
		        } else {
		            isSuccess = false;
		        }
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		    return isSuccess;
	
		    }
		
		public static List<Songs> getSongDetails(){
			
			ArrayList<Songs> song = new ArrayList<>();
			
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * FROM songs";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int sid = rs.getInt(1);
					String name = rs.getString(2);
					String des = rs.getString(7);
					
					Songs s = new Songs(sid, name, des);
					
					song.add(s);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return song;
		}
		
		public static boolean deleteSong(int id) {
			
			boolean isSuccess = false;
			
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "DELETE FROM songs WHERE sid = "+id+";";
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					
					isSuccess = true;
				}else {
					
					isSuccess = false;
				}
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			
			return isSuccess;
		}
		
		public static List<Songs> getSongLibraryDetails(int uid){
			
			ArrayList<Songs> songs = new ArrayList<>();
			
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT s.sid, s.name, s.description FROM songs s, download d, user u where s.sid = d.sid and u.uid = d.uid and u.uid = "+uid+";";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int sid = rs.getInt(1);
					String name = rs.getString(2);
					String des = rs.getString(3);
					
					Songs l = new Songs(sid, name, des);
					
					songs.add(l);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return songs;
		}
		
		public static List<Songs> getAllSongs(){
			
			ArrayList<Songs> Allsongs = new ArrayList<>();
			
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * From songs;";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int sid = rs.getInt(1);
					String name = rs.getString(2);
					String des = rs.getString(7);
					
					Songs all = new Songs(sid, name, des);
					
					Allsongs.add(all);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return Allsongs;
		}
		
			public static boolean insertToLibrary(int sid, int uid) {
			
			boolean isSuccess = false;
			
			try {
		        con = DBConnect.getConnection();
		        stmt = con.createStatement();
		        
		        String sql = "INSERT INTO download VALUES("+sid+", "+uid+", 0, 1);";
		        
		        int rs = stmt.executeUpdate(sql);
		        
		        if (rs > 0) {
		            isSuccess = true;
		        } else {
		            isSuccess = false;
		        }
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		    return isSuccess;
	
		    }
			
			public static boolean deleteFromLibrary(int uid, int sid) {
				
				boolean isSuccess = false;
				
				try {
					
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "DELETE FROM download WHERE sid="+sid+" and uid="+uid+";";
					int rs = stmt.executeUpdate(sql);
					
					if(rs > 0) {
						
						isSuccess = true;
					}else {
						
						isSuccess = false;
					}
					
				}catch(Exception e) {
					
					e.printStackTrace();
				}
				
				return isSuccess;
			}
			
			public static boolean insertCustomer(String name, String username, String password) {
				
				isSuccess = false;
				
				try {
			        con = DBConnect.getConnection();
			        stmt = con.createStatement();
			        
			        String sql = "INSERT INTO user VALUES(0, '"+username+"', '"+name+"', '"+password+"', 1);";
			        
			        int rs = stmt.executeUpdate(sql);
			        
			        if (rs > 0) {
			            isSuccess = true;
			        } else {
			            isSuccess = false;
			        }
			        
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			    
			    return isSuccess;
		
			    }
			
			public static boolean getCustomer(String username){
				
				isSuccess = false;
				
				try {
					
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "SELECT * FROM user WHERE username='"+username+"'";
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						
						isSuccess = true;
					}
					
				
				}catch(Exception e) {
					
					e.printStackTrace();
				}
				
				return isSuccess;
			}
			
			public static List<Customer> validateCustomer(String username, String password){
				
				ArrayList<Customer> customer = new ArrayList<>();
				
				try {
					
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "SELECT * FROM user WHERE username='"+username+"' and password='"+password+"'";
					rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						int uid = rs.getInt(1);
						String uname = rs.getString(2);
						String name = rs.getString(3);
						String pwd = rs.getString(4);
						
						Customer cus = new Customer(uid, uname, name, pwd);
						
						customer.add(cus);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return customer;
			}
			
			public static List<Artists> getAllArtists(){
				
				ArrayList<Artists> AllArtists = new ArrayList<>();
				
				try {
					
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "SELECT * From artist;";
					rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						int aid = rs.getInt(1);
						String name = rs.getString(2);
						String username = rs.getString(3);
						String password = rs.getString(4);
						
						Artists all = new Artists(aid, name, username, password);
						
						AllArtists.add(all);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return AllArtists;
			}
		}
