/*  1:   */ package br.com.interpsync.interdb.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Coxins_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Coxins_INTERDBDAO
/* 13:   */ {
/* 14:   */   private Connection connection;
/* 15:   */   
/* 16:   */   public Coxins_INTERDBDAO()
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
/* 45:   */   public void inserir(Coxins_ERP coxin)
/* 46:   */     throws ClassNotFoundException, SQLException, Exception
/* 47:   */   {
/* 48:49 */     String sql = "INSERT INTO COXINS_ERP (CodCX,DescrCX,PesoCX,Stei) VALUES (?,?,?,?)";
/* 49:50 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 50:51 */     stmt.setString(1, coxin.getCodCX());
/* 51:52 */     stmt.setString(2, coxin.getDescrCX());
/* 52:53 */     stmt.setBigDecimal(3, coxin.getPesoCX());
/* 53:54 */     stmt.setInt(4, coxin.getStei());
/* 54:55 */     stmt.executeUpdate();
/* 55:56 */     stmt.close();
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void atualizar(Coxins_ERP coxin)
/* 59:   */     throws ClassNotFoundException, SQLException, Exception
/* 60:   */   {
/* 61:63 */     String sql = "UPDATE COXINS_ERP SET DescrCX = ?, PesoCX = ?, Stei = ? WHERE CodCX = ?";
/* 62:64 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 63:65 */     stmt.setString(1, coxin.getDescrCX());
/* 64:66 */     stmt.setBigDecimal(2, coxin.getPesoCX());
/* 65:67 */     stmt.setInt(3, coxin.getStei());
/* 66:68 */     stmt.setString(4, coxin.getCodCX());
/* 67:69 */     stmt.executeUpdate();
/* 68:70 */     stmt.close();
/* 69:   */   }
/* 70:   */   
/* 71:   */   public Coxins_ERP localizarPorId(String id)
/* 72:   */     throws ClassNotFoundException, SQLException, Exception
/* 73:   */   {
/* 74:77 */     String sql = "SELECT CodCX, DescrCX, PesoCX, Stei FROM COXINS_ERP WHERE CodCX = ?";
/* 75:78 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 76:79 */     stmt.setString(1, id);
/* 77:80 */     stmt.executeQuery();
/* 78:81 */     ResultSet rs = stmt.getResultSet();
/* 79:82 */     Coxins_ERP coxin = new Coxins_ERP();
/* 80:83 */     if (rs.next())
/* 81:   */     {
/* 82:84 */       coxin.setCodCX(rs.getString("CodCX"));
/* 83:85 */       coxin.setDescrCX(rs.getString("DescrCX"));
/* 84:86 */       coxin.setPesoCX(rs.getBigDecimal("PesoCX"));
/* 85:87 */       coxin.setStei(rs.getInt("Stei"));
/* 86:   */     }
/* 87:89 */     stmt.close();
/* 88:90 */     return coxin;
/* 89:   */   }
/* 90:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.Coxins_INTERDBDAO
 * JD-Core Version:    0.7.0.1
 */