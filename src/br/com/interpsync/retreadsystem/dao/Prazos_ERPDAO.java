/*   1:    */ package br.com.interpsync.retreadsystem.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Prazos_ERP;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ 
/*  14:    */ public class Prazos_ERPDAO
/*  15:    */ {
/*  16:    */   private Connection connection;
/*  17:    */   
/*  18:    */   public Prazos_ERPDAO()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 27 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  23:    */     }
/*  24:    */     catch (SQLException ex)
/*  25:    */     {
/*  26: 29 */       Logger.getLogger(Prazos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  27:    */     }
/*  28:    */     catch (ClassNotFoundException ex)
/*  29:    */     {
/*  30: 31 */       Logger.getLogger(Prazos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  31:    */     }
/*  32:    */     catch (Exception ex)
/*  33:    */     {
/*  34: 33 */       Logger.getLogger(Prazos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  35:    */     }
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Connection getConnection()
/*  39:    */     throws SQLException, ClassNotFoundException, Exception
/*  40:    */   {
/*  41: 41 */     if ((this.connection == null) || (this.connection.isClosed())) {
/*  42: 42 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  43:    */     }
/*  44: 44 */     return this.connection;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public List<Prazos_ERP> listarTodos()
/*  48:    */     throws SQLException, ClassNotFoundException, Exception
/*  49:    */   {
/*  50: 51 */     String sql = "SELECT ALL * FROM PRAZOS_ERP";
/*  51: 52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  52: 53 */     stmt.executeQuery();
/*  53: 54 */     ResultSet rs = stmt.getResultSet();
/*  54: 55 */     List<Prazos_ERP> lista = new ArrayList();
/*  55: 56 */     while (rs.next())
/*  56:    */     {
/*  57: 57 */       Prazos_ERP prazo = new Prazos_ERP();
/*  58: 58 */       prazo.setCodPR(rs.getString("CodPR"));
/*  59: 59 */       prazo.setDescrPR(rs.getString("DescrPR"));
/*  60: 60 */       prazo.setCondPR(rs.getString("CondPR"));
/*  61: 61 */       prazo.setParcPR(Integer.valueOf(rs.getInt("ParcPR")));
/*  62: 62 */       prazo.setAlterPR(rs.getString("AlterPR"));
/*  63: 63 */       prazo.setStEI(rs.getInt("StEI"));
/*  64: 64 */       lista.add(prazo);
/*  65:    */     }
/*  66: 66 */     stmt.close();
/*  67: 67 */     return lista;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public List<Prazos_ERP> listarNovos()
/*  71:    */     throws SQLException, ClassNotFoundException, Exception
/*  72:    */   {
/*  73: 74 */     String sql = "SELECT * FROM PRAZOS_ERP WHERE StEI <> 1";
/*  74: 75 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  75: 76 */     stmt.executeQuery();
/*  76: 77 */     ResultSet rs = stmt.getResultSet();
/*  77: 78 */     List<Prazos_ERP> lista = new ArrayList();
/*  78: 79 */     while (rs.next())
/*  79:    */     {
/*  80: 80 */       Prazos_ERP prazo = new Prazos_ERP();
/*  81: 81 */       prazo.setCodPR(rs.getString("CodPR"));
/*  82: 82 */       prazo.setDescrPR(rs.getString("DescrPR"));
/*  83: 83 */       prazo.setCondPR(rs.getString("CondPR"));
/*  84: 84 */       prazo.setParcPR(Integer.valueOf(rs.getInt("ParcPR")));
/*  85: 85 */       prazo.setAlterPR(rs.getString("AlterPR"));
/*  86: 86 */       prazo.setStEI(rs.getInt("StEI"));
/*  87: 87 */       lista.add(prazo);
/*  88:    */     }
/*  89: 89 */     stmt.close();
/*  90: 90 */     return lista;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void atualizar(Prazos_ERP prazo)
/*  94:    */     throws ClassNotFoundException, SQLException, Exception
/*  95:    */   {
/*  96: 97 */     String sql = "UPDATE PRAZOS_ERP SET DescrPR = ?, CondPR = ?, ParcPR = ?, AlterPR = ?, StEI = ? WHERE CodPR = ?";
/*  97: 98 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  98: 99 */     stmt.setString(1, prazo.getDescrPR());
/*  99:100 */     stmt.setString(2, prazo.getCondPR());
/* 100:101 */     stmt.setInt(3, prazo.getParcPR().intValue());
/* 101:102 */     stmt.setString(4, prazo.getAlterPR());
/* 102:103 */     stmt.setInt(5, prazo.getStEI());
/* 103:104 */     stmt.setString(6, prazo.getCodPR());
/* 104:105 */     stmt.executeUpdate();
/* 105:106 */     stmt.close();
/* 106:    */   }
/* 107:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Prazos_ERPDAO
 * JD-Core Version:    0.7.0.1
 */