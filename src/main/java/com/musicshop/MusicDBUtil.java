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
			
			public static boolean updateArtist(int id, String name, String username, String password ) {
				
				boolean isSuccess = false;
				
				try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "update artist set name='"+name+"', username='"+username+"', password='"+password+"' where aid="+id+";";
					
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
			
			public static boolean insertArtist(String name, String username, String password) {
				
				isSuccess = false;
				
				try {
			        con = DBConnect.getConnection();
			        stmt = con.createStatement();
			        
			        String sql = "INSERT INTO artist VALUES(0, '"+name+"', '"+username+"', '"+password+"', 1);";
			        
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
			public static List<Terms> getAllterms(){
				
				ArrayList<Terms> AllTerms = new ArrayList<>();
				
				try {
					
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "SELECT * From terms;";
					rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						int tid = rs.getInt(1);
						String des = rs.getString(2);
						
						Terms all = new Terms(tid, des);
						
						AllTerms.add(all);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return AllTerms;
			}
			
			public static boolean updateTerms(int id, String description) {
				
				boolean isSuccess = false;
				
				try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "update terms set description='"+description+"' where tid="+id+"";
					
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
			
			public static boolean AddTerms(String des) {
				
				isSuccess = false;
				
				try {
			        con = DBConnect.getConnection();
			        stmt = con.createStatement();
			        
			        String sql = "INSERT INTO terms VALUES(0, '"+des+"', 1);";
			        
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
			
			public static boolean deleteTerms(int terms) {
				
				boolean isSuccess = false;
				
				try {
					
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "DELETE FROM terms WHERE tid='"+terms+"'";
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
			
			public static boolean updateSong(int id, String description, String song) {
				
				boolean isSuccess = false;
				
				try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "update songs set description='"+description+"', name='"+song+"' where sid="+id+"";
					
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
			
			public static boolean deleteFromLibraryByArtist(int sid) {
				
				boolean isSuccess = false;
				
				try {
					
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "DELETE FROM download WHERE sid="+sid+";";
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
			
			
			public static List<Songs> searchSongs(String search){
				
				ArrayList<Songs> song = new ArrayList<>();
				
				try {
					
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "SELECT * FROM songs WHERE name LIKE '%"+search+"%'";
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
			
			public static List<Artists> searchArtists(String search){
				
				ArrayList<Artists> AllArtists = new ArrayList<>();
				
				try {
					
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "SELECT * From artist where name LIKE '%"+search+"%' OR username LIKE '%"+search+"%';";
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
			
			public static List<Terms> searchTerms(String desc){
				
				ArrayList<Terms> AllTerms = new ArrayList<>();
				
				try {
					
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "SELECT * From terms WHERE description LIKE '%"+desc+"%';";
					rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						int tid = rs.getInt(1);
						String des = rs.getString(2);
						
						Terms all = new Terms(tid, des);
						
						AllTerms.add(all);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return AllTerms;
			}
			
			public static boolean getArtist(String username){
				
				isSuccess = false;
				
				try {
					
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "SELECT * FROM artist WHERE username='"+username+"'";
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						
						isSuccess = true;
					}
					
				
				}catch(Exception e) {
					
					e.printStackTrace();
				}
				
				return isSuccess;
			}
			
			public static List<Artists> validateArtist(String username, String password){
				
				ArrayList<Artists> artist = new ArrayList<>();
				
				try {
					
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql = "SELECT * FROM artist WHERE username='"+username+"' and password='"+password+"'";
					rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						int aid = rs.getInt(1);
						String uname = rs.getString(3);
						String name = rs.getString(2);
						String pwd = rs.getString(4);
						
						Artists art = new Artists(aid, name, uname, pwd);
						
						artist.add(art);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return artist;
			}
		}
