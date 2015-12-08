/*  1:   */ package br.com.interpsync.interdb.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Prazos_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Prazos_INTERDBDAO
/* 13:   */ {
/* 14:   */   private Connection connection;
/* 15:   */   
/* 16:   */   public Prazos_INTERDBDAO()
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
/* 45:   */   public void inserir(Prazos_ERP prazo)
/* 46:   */     throws SQLException, ClassNotFoundException, Exception
/* 47:   */   {
/* 48:49 */     String sql = "INSERT INTO PRAZOS_ERP (CodPR,DescrPR,CondPR,ParcPR,AlterPR,StEI) VALUES (?,?,?,?,?,?)";
/* 49:   */     
/* 50:51 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 51:52 */     stmt.setString(1, prazo.getCodPR());
/* 52:53 */     stmt.setString(2, prazo.getDescrPR());
/* 53:54 */     stmt.setString(3, prazo.getCondPR());
/* 54:55 */     stmt.setInt(4, prazo.getParcPR().intValue());
/* 55:56 */     stmt.setString(5, prazo.getAlterPR());
/* 56:57 */     stmt.setInt(6, prazo.getStEI());
/* 57:58 */     stmt.executeUpdate();
/* 58:59 */     stmt.close();
/* 59:   */   }
/* 60:   */   
/* 61:   */   public void atualizar(Prazos_ERP prazo)
/* 62:   */     throws ClassNotFoundException, SQLException, Exception
/* 63:   */   {
/* 64:66 */     String sql = "UPDATE PRAZOS_ERP SET DescrPR = ?, CondPR = ?, ParcPR = ?, AlterPR = ?, StEI = ?    WHERE  CodPR = ?";
/* 65:   */     
/* 66:68 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 67:69 */     stmt.setString(1, prazo.getDescrPR());
/* 68:70 */     stmt.setString(2, prazo.getCondPR());
/* 69:71 */     stmt.setInt(3, prazo.getParcPR().intValue());
/* 70:72 */     stmt.setString(4, prazo.getAlterPR());
/* 71:73 */     stmt.setInt(5, prazo.getStEI());
/* 72:74 */     stmt.setString(6, prazo.getCodPR());
/* 73:75 */     stmt.executeUpdate();
/* 74:76 */     stmt.close();
/* 75:   */   }
/* 76:   */   
/* 77:   */   public Prazos_ERP localizarPorID(String id)
/* 78:   */     throws ClassNotFoundException, SQLException, Exception
/* 79:   */   {
/* 80:83 */     String sql = "SELECT CodPR, DescrPR, CondPR, ParcPR, AlterPR, StEI FROM PRAZOS_ERP    WHERE CodPR = ?";
/* 81:   */     
/* 82:85 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 83:86 */     stmt.setString(1, id);
/* 84:87 */     stmt.executeQuery();
/* 85:88 */     ResultSet rs = stmt.getResultSet();
/* 86:89 */     Prazos_ERP prazo = new Prazos_ERP();
/* 87:90 */     if (rs.next())
/* 88:   */     {
/* 89:91 */       prazo.setCodPR(rs.getString("CodPR"));
/* 90:92 */       prazo.setDescrPR(rs.getString("DescrPR"));
/* 91:93 */       prazo.setCondPR(rs.getString("CondPR"));
/* 92:94 */       prazo.setParcPR(Integer.valueOf(rs.getInt("ParcPR")));
/* 93:95 */       prazo.setAlterPR(rs.getString("AlterPR"));
/* 94:96 */       prazo.setStEI(rs.getInt("StEI"));
/* 95:   */     }
/* 96:98 */     stmt.close();
/* 97:99 */     return prazo;
/* 98:   */   }
/* 99:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.Prazos_INTERDBDAO
 * JD-Core Version:    0.7.0.1
 */