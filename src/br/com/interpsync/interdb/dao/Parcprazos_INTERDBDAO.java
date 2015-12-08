/*  1:   */ package br.com.interpsync.interdb.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Parcprazos_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Parcprazos_INTERDBDAO
/* 13:   */ {
/* 14:   */   private Connection connection;
/* 15:   */   
/* 16:   */   public Parcprazos_INTERDBDAO()
/* 17:   */   {
/* 18:   */     try
/* 19:   */     {
/* 20:25 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/* 21:   */     }
/* 22:   */     catch (SQLException ex)
/* 23:   */     {
/* 24:27 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 25:   */     }
/* 26:   */     catch (ClassNotFoundException ex)
/* 27:   */     {
/* 28:29 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 29:   */     }
/* 30:   */     catch (Exception ex)
/* 31:   */     {
/* 32:31 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 33:   */     }
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Connection getConnection()
/* 37:   */     throws SQLException, ClassNotFoundException, Exception
/* 38:   */   {
/* 39:39 */     if ((this.connection == null) || (this.connection.isClosed())) {
/* 40:40 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/* 41:   */     }
/* 42:42 */     return this.connection;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void inserir(Parcprazos_ERP parc)
/* 46:   */     throws SQLException, ClassNotFoundException, Exception
/* 47:   */   {
/* 48:49 */     String sql = "INSERT INTO PARCPRAZOS_ERP (CodPR,ParcPR,VencPR,StEI) VALUES (?,?,?,?)";
/* 49:   */     
/* 50:51 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 51:52 */     stmt.setString(1, parc.getCodPR());
/* 52:53 */     stmt.setInt(2, parc.getParcPR().intValue());
/* 53:54 */     stmt.setInt(3, parc.getVencPR().intValue());
/* 54:55 */     stmt.setInt(4, parc.getStEI());
/* 55:56 */     stmt.executeUpdate();
/* 56:57 */     stmt.close();
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void atualizar(Parcprazos_ERP parc)
/* 60:   */     throws ClassNotFoundException, SQLException, Exception
/* 61:   */   {
/* 62:64 */     String sql = "UPDATE PARCPRAZOS_ERP SET  ParcPR = ?, VencPR = ?, StEI = ? WHERE CodPR = ?";
/* 63:65 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 64:66 */     stmt.setInt(1, parc.getParcPR().intValue());
/* 65:67 */     stmt.setInt(2, parc.getVencPR().intValue());
/* 66:68 */     stmt.setInt(3, parc.getStEI());
/* 67:69 */     stmt.setString(4, parc.getCodPR());
/* 68:70 */     stmt.executeUpdate();
/* 69:71 */     stmt.close();
/* 70:   */   }
/* 71:   */   
/* 72:   */   public Parcprazos_ERP localizarPorID(String id)
/* 73:   */     throws ClassNotFoundException, SQLException, Exception
/* 74:   */   {
/* 75:78 */     String sql = "SELECT CodPR, ParcPR, VencPR, StEI FROM PARCPRAZOS_ERP WHERE CodPR = ?";
/* 76:79 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 77:80 */     stmt.setString(1, id);
/* 78:81 */     stmt.executeQuery();
/* 79:82 */     ResultSet rs = stmt.getResultSet();
/* 80:83 */     Parcprazos_ERP parc = new Parcprazos_ERP();
/* 81:84 */     if (rs.next())
/* 82:   */     {
/* 83:85 */       parc.setCodPR(rs.getString("CodPR"));
/* 84:86 */       parc.setParcPR(Integer.valueOf(rs.getInt("ParcPR")));
/* 85:87 */       parc.setVencPR(Integer.valueOf(rs.getInt("VencPR")));
/* 86:88 */       parc.setStEI(rs.getInt("StEI"));
/* 87:   */     }
/* 88:90 */     stmt.close();
/* 89:91 */     return parc;
/* 90:   */   }
/* 91:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.Parcprazos_INTERDBDAO
 * JD-Core Version:    0.7.0.1
 */