/*  1:   */ package br.com.interpsync.interdb.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Modelos_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Modelos_INTERDBDAO
/* 13:   */ {
/* 14:   */   private Connection connection;
/* 15:   */   
/* 16:   */   public Modelos_INTERDBDAO()
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
/* 45:   */   public void inserir(Modelos_ERP modelo)
/* 46:   */     throws ClassNotFoundException, SQLException, Exception
/* 47:   */   {
/* 48:49 */     String sql = "INSERT INTO MODELOS_ERP (CodMO,DescrMO,MarcaMO,VocMO,StEI) VALUES (?,?,?,?,?)";
/* 49:   */     
/* 50:51 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 51:52 */     stmt.setString(1, modelo.getCodMO());
/* 52:53 */     stmt.setString(2, modelo.getDescrMO());
/* 53:54 */     stmt.setString(3, modelo.getMarcaMO());
/* 54:55 */     stmt.setString(4, modelo.getVocMO());
/* 55:56 */     stmt.setInt(5, modelo.getStEI());
/* 56:57 */     stmt.executeUpdate();
/* 57:58 */     stmt.close();
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void atualizar(Modelos_ERP modelo)
/* 61:   */     throws ClassNotFoundException, SQLException, Exception
/* 62:   */   {
/* 63:64 */     String sql = "UPDATE MODELOS_ERP    SET    DescrMO = ?, MarcaMO = ?, VocMO = ?, StEI = ?    WHERE  CodMO = ?";
/* 64:   */     
/* 65:   */ 
/* 66:67 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 67:68 */     stmt.setString(1, modelo.getDescrMO());
/* 68:69 */     stmt.setString(2, modelo.getMarcaMO());
/* 69:70 */     stmt.setString(3, modelo.getVocMO());
/* 70:71 */     stmt.setInt(4, modelo.getStEI());
/* 71:72 */     stmt.setString(5, modelo.getCodMO());
/* 72:73 */     stmt.executeUpdate();
/* 73:74 */     stmt.close();
/* 74:   */   }
/* 75:   */   
/* 76:   */   public Modelos_ERP localizarPorID(String id)
/* 77:   */     throws ClassNotFoundException, SQLException, Exception
/* 78:   */   {
/* 79:81 */     String sql = "SELECT CodMO, DescrMO, MarcaMO, VocMO, StEI FROM MODELOS_ERP WHERE CodMO = ?";
/* 80:82 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 81:83 */     stmt.setString(1, id);
/* 82:84 */     stmt.executeQuery();
/* 83:85 */     ResultSet rs = stmt.getResultSet();
/* 84:86 */     Modelos_ERP modelo = new Modelos_ERP();
/* 85:87 */     if (rs.next())
/* 86:   */     {
/* 87:88 */       modelo.setCodMO(rs.getString("CodMO"));
/* 88:89 */       modelo.setDescrMO(rs.getString("DescrMO"));
/* 89:90 */       modelo.setMarcaMO(rs.getString("MarcaMO"));
/* 90:91 */       modelo.setVocMO(rs.getString("VocMO"));
/* 91:92 */       modelo.setStEI(rs.getInt("StEI"));
/* 92:   */     }
/* 93:94 */     stmt.close();
/* 94:95 */     return modelo;
/* 95:   */   }
/* 96:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.Modelos_INTERDBDAO
 * JD-Core Version:    0.7.0.1
 */