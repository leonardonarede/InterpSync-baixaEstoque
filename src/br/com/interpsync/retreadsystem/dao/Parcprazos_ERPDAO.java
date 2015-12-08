/*  1:   */ package br.com.interpsync.retreadsystem.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Parcprazos_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.ArrayList;
/* 10:   */ import java.util.List;
/* 11:   */ import java.util.logging.Level;
/* 12:   */ import java.util.logging.Logger;
/* 13:   */ 
/* 14:   */ public class Parcprazos_ERPDAO
/* 15:   */ {
/* 16:   */   private Connection connection;
/* 17:   */   
/* 18:   */   public Parcprazos_ERPDAO()
/* 19:   */   {
/* 20:   */     try
/* 21:   */     {
/* 22:27 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/* 23:   */     }
/* 24:   */     catch (SQLException ex)
/* 25:   */     {
/* 26:29 */       Logger.getLogger(Parcprazos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 27:   */     }
/* 28:   */     catch (ClassNotFoundException ex)
/* 29:   */     {
/* 30:31 */       Logger.getLogger(Parcprazos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 31:   */     }
/* 32:   */     catch (Exception ex)
/* 33:   */     {
/* 34:33 */       Logger.getLogger(Parcprazos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
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
/* 47:   */   public List<Parcprazos_ERP> listarNovos()
/* 48:   */     throws SQLException, ClassNotFoundException, Exception
/* 49:   */   {
/* 50:50 */     String sql = "SELECT * FROM PARCPRAZOS_ERP WHERE StEI <> 1";
/* 51:51 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 52:52 */     stmt.executeQuery();
/* 53:53 */     ResultSet rs = stmt.getResultSet();
/* 54:54 */     List<Parcprazos_ERP> prazos = new ArrayList();
/* 55:55 */     while (rs.next())
/* 56:   */     {
/* 57:56 */       Parcprazos_ERP prazo = new Parcprazos_ERP();
/* 58:57 */       prazo.setCodPR(rs.getString("CodPR"));
/* 59:58 */       prazo.setParcPR(Integer.valueOf(rs.getInt("ParcPR")));
/* 60:59 */       prazo.setVencPR(Integer.valueOf(rs.getInt("VencPR")));
/* 61:60 */       prazo.setStEI(rs.getInt("StEI"));
/* 62:61 */       prazos.add(prazo);
/* 63:   */     }
/* 64:63 */     stmt.close();
/* 65:64 */     return prazos;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public List<Parcprazos_ERP> listarTodos()
/* 69:   */     throws SQLException, ClassNotFoundException, Exception
/* 70:   */   {
/* 71:71 */     String sql = "SELECT ALL * FROM PARCPRAZOS_ERP";
/* 72:72 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 73:73 */     stmt.executeQuery();
/* 74:74 */     ResultSet rs = stmt.getResultSet();
/* 75:75 */     List<Parcprazos_ERP> prazos = new ArrayList();
/* 76:76 */     while (rs.next())
/* 77:   */     {
/* 78:77 */       Parcprazos_ERP prazo = new Parcprazos_ERP();
/* 79:78 */       prazo.setCodPR(rs.getString("CodPR"));
/* 80:79 */       prazo.setParcPR(Integer.valueOf(rs.getInt("ParcPR")));
/* 81:80 */       prazo.setVencPR(Integer.valueOf(rs.getInt("VencPR")));
/* 82:81 */       prazo.setStEI(rs.getInt("StEI"));
/* 83:82 */       prazos.add(prazo);
/* 84:   */     }
/* 85:84 */     stmt.close();
/* 86:85 */     return prazos;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public void atualizar(Parcprazos_ERP parc)
/* 90:   */     throws ClassNotFoundException, SQLException, Exception
/* 91:   */   {
/* 92:92 */     String sql = "UPDATE PARCPRAZOS_ERP SET ParcPR = ?, VencPR = ?, StEI = ? WHERE CodPR = ?";
/* 93:93 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 94:94 */     stmt.setInt(1, parc.getParcPR().intValue());
/* 95:95 */     stmt.setInt(2, parc.getVencPR().intValue());
/* 96:96 */     stmt.setInt(3, parc.getStEI());
/* 97:97 */     stmt.setString(4, parc.getCodPR());
/* 98:98 */     stmt.executeUpdate();
/* 99:99 */     stmt.close();
/* :0:   */   }
/* :1:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Parcprazos_ERPDAO
 * JD-Core Version:    0.7.0.1
 */