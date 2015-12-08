/*  1:   */ package br.com.interpsync.interdb.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Laudosrec_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Laudosrec_INTERDBDAO
/* 13:   */ {
/* 14:   */   private Connection connection;
/* 15:   */   
/* 16:   */   public Laudosrec_INTERDBDAO()
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
/* 45:   */   public void inserir(Laudosrec_ERP laudo)
/* 46:   */     throws SQLException, ClassNotFoundException, Exception
/* 47:   */   {
/* 48:49 */     String sql = "INSERT INTO LAUDOSREC_ERP (CodLA,DescrLA,HisLA,StEI)  VALUES (?,?,?,?)";
/* 49:   */     
/* 50:51 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 51:52 */     stmt.setString(1, laudo.getCodLA());
/* 52:53 */     stmt.setString(2, laudo.getDescrLA());
/* 53:54 */     stmt.setString(3, laudo.getHisLA());
/* 54:55 */     stmt.setInt(4, laudo.getStEI());
/* 55:56 */     stmt.executeUpdate();
/* 56:57 */     stmt.close();
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void atualizar(Laudosrec_ERP laudo)
/* 60:   */     throws ClassNotFoundException, SQLException, Exception
/* 61:   */   {
/* 62:64 */     String sql = "UPDATE LAUDOSREC_ERP SET StEI = ? WHERE CodLA = ?";
/* 63:65 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 64:66 */     stmt.setInt(1, laudo.getStEI());
/* 65:67 */     stmt.setString(2, laudo.getCodLA());
/* 66:68 */     stmt.executeUpdate();
/* 67:69 */     stmt.close();
/* 68:   */   }
/* 69:   */   
/* 70:   */   public Laudosrec_ERP localizarPorID(String id)
/* 71:   */     throws ClassNotFoundException, SQLException, Exception
/* 72:   */   {
/* 73:76 */     String sql = "SELECT CodLA, DescrLA, HisLA, StEI FROM LAUDOSREC_ERP WHERE CodLA = ?";
/* 74:77 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 75:78 */     stmt.setString(1, id);
/* 76:79 */     stmt.executeQuery();
/* 77:80 */     ResultSet rs = stmt.getResultSet();
/* 78:81 */     Laudosrec_ERP laudo = new Laudosrec_ERP();
/* 79:82 */     if (rs.next())
/* 80:   */     {
/* 81:83 */       laudo.setCodLA(rs.getString("CodLA"));
/* 82:84 */       laudo.setDescrLA(rs.getString("DescrLA"));
/* 83:85 */       laudo.setHisLA(rs.getString("HisLA"));
/* 84:86 */       laudo.setStEI(rs.getInt("StEI"));
/* 85:   */     }
/* 86:88 */     stmt.close();
/* 87:89 */     return laudo;
/* 88:   */   }
/* 89:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.Laudosrec_INTERDBDAO
 * JD-Core Version:    0.7.0.1
 */