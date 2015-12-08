/*  1:   */ package br.com.interpsync.retreadsystem.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Laudosrec_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.ArrayList;
/* 10:   */ import java.util.List;
/* 11:   */ import java.util.logging.Level;
/* 12:   */ import java.util.logging.Logger;
/* 13:   */ 
/* 14:   */ public class Laudosrec_ERPDAO
/* 15:   */ {
/* 16:   */   private Connection connection;
/* 17:   */   
/* 18:   */   public Laudosrec_ERPDAO()
/* 19:   */   {
/* 20:   */     try
/* 21:   */     {
/* 22:27 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/* 23:   */     }
/* 24:   */     catch (SQLException ex)
/* 25:   */     {
/* 26:29 */       Logger.getLogger(Laudosrec_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 27:   */     }
/* 28:   */     catch (ClassNotFoundException ex)
/* 29:   */     {
/* 30:31 */       Logger.getLogger(Laudosrec_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 31:   */     }
/* 32:   */     catch (Exception ex)
/* 33:   */     {
/* 34:33 */       Logger.getLogger(Laudosrec_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 35:   */     }
/* 36:   */   }
/* 37:   */   
/* 38:   */   public Connection getConnection()
/* 39:   */     throws SQLException, ClassNotFoundException, Exception
/* 40:   */   {
/* 41:41 */     if ((this.connection == null) || (this.connection.isClosed())) {
/* 42:42 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/* 43:   */     }
/* 44:44 */     return this.connection;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public List<Laudosrec_ERP> listarTodos()
/* 48:   */     throws SQLException, ClassNotFoundException, Exception
/* 49:   */   {
/* 50:51 */     String sql = "SELECT ALL * FROM LAUDOSREC_ERP";
/* 51:52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 52:53 */     stmt.executeQuery();
/* 53:54 */     ResultSet rs = stmt.getResultSet();
/* 54:55 */     List<Laudosrec_ERP> laudos = new ArrayList();
/* 55:56 */     while (rs.next())
/* 56:   */     {
/* 57:57 */       Laudosrec_ERP laudo = new Laudosrec_ERP();
/* 58:58 */       laudo.setCodLA(rs.getString("CodLA"));
/* 59:59 */       laudo.setDescrLA(rs.getString("DescrLA"));
/* 60:60 */       laudo.setHisLA(rs.getString("HisLA"));
/* 61:61 */       laudo.setStEI(rs.getInt("StEI"));
/* 62:62 */       laudos.add(laudo);
/* 63:   */     }
/* 64:64 */     stmt.close();
/* 65:65 */     return laudos;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public List<Laudosrec_ERP> listarNovos()
/* 69:   */     throws SQLException, ClassNotFoundException, Exception
/* 70:   */   {
/* 71:71 */     String sql = "SELECT * FROM LAUDOSREC_ERP WHERE StEI <> 1";
/* 72:72 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 73:73 */     stmt.executeQuery();
/* 74:74 */     ResultSet rs = stmt.getResultSet();
/* 75:75 */     List<Laudosrec_ERP> laudos = new ArrayList();
/* 76:76 */     while (rs.next())
/* 77:   */     {
/* 78:77 */       Laudosrec_ERP laudo = new Laudosrec_ERP();
/* 79:78 */       laudo.setCodLA(rs.getString("CodLA"));
/* 80:79 */       laudo.setDescrLA(rs.getString("DescrLA"));
/* 81:80 */       laudo.setHisLA(rs.getString("HisLA"));
/* 82:81 */       laudo.setStEI(rs.getInt("StEI"));
/* 83:82 */       laudos.add(laudo);
/* 84:   */     }
/* 85:84 */     stmt.close();
/* 86:85 */     return laudos;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public void atualizar(Laudosrec_ERP laudo)
/* 90:   */     throws SQLException, ClassNotFoundException, Exception
/* 91:   */   {
/* 92:92 */     String sql = "UPDATE LAUDOSREC_ERP SET StEI = ? WHERE CodLA = ?";
/* 93:   */     
/* 94:94 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 95:95 */     stmt.setInt(1, laudo.getStEI());
/* 96:96 */     stmt.setString(2, laudo.getCodLA());
/* 97:97 */     stmt.executeUpdate();
/* 98:98 */     stmt.close();
/* 99:   */   }
/* :0:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Laudosrec_ERPDAO
 * JD-Core Version:    0.7.0.1
 */