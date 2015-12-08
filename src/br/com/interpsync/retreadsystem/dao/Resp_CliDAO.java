/*   1:    */ package br.com.interpsync.retreadsystem.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Resp_Cli;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ 
/*  14:    */ public class Resp_CliDAO
/*  15:    */ {
/*  16:    */   private Connection connection;
/*  17:    */   
/*  18:    */   public Resp_CliDAO()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 28 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  23:    */     }
/*  24:    */     catch (SQLException ex)
/*  25:    */     {
/*  26: 30 */       Logger.getLogger(Resp_CliDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  27:    */     }
/*  28:    */     catch (ClassNotFoundException ex)
/*  29:    */     {
/*  30: 32 */       Logger.getLogger(Resp_CliDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  31:    */     }
/*  32:    */     catch (Exception ex)
/*  33:    */     {
/*  34: 34 */       Logger.getLogger(Resp_CliDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  35:    */     }
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Connection getConnection()
/*  39:    */     throws SQLException, ClassNotFoundException, Exception
/*  40:    */   {
/*  41: 42 */     if ((this.connection == null) || (this.connection.isClosed())) {
/*  42: 43 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  43:    */     }
/*  44: 45 */     return this.connection;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public List<Resp_Cli> listarTodos()
/*  48:    */     throws SQLException, ClassNotFoundException, Exception
/*  49:    */   {
/*  50: 52 */     String sql = "SELECT ALL * FROM Resp_Cli";
/*  51: 53 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  52: 54 */     stmt.executeQuery();
/*  53: 55 */     ResultSet rs = stmt.getResultSet();
/*  54: 56 */     List<Resp_Cli> lista = new ArrayList();
/*  55: 57 */     while (rs.next())
/*  56:    */     {
/*  57: 58 */       Resp_Cli resp = new Resp_Cli();
/*  58: 59 */       resp.setCNPJCPF(rs.getString("CNPJCPF"));
/*  59: 60 */       resp.setRespVencidas(rs.getBigDecimal("RespVencidas"));
/*  60: 61 */       resp.setRespAVencer(rs.getBigDecimal("RespAVencer"));
/*  61: 62 */       resp.setStEI(rs.getInt("StEI"));
/*  62: 63 */       lista.add(resp);
/*  63:    */     }
/*  64: 65 */     stmt.close();
/*  65: 66 */     return lista;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public List<Resp_Cli> listarNovos()
/*  69:    */     throws SQLException, ClassNotFoundException, Exception
/*  70:    */   {
/*  71: 73 */     String sql = "SELECT * FROM Resp_Cli WHERE StEI <> 1";
/*  72: 74 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  73: 75 */     stmt.executeQuery();
/*  74: 76 */     ResultSet rs = stmt.getResultSet();
/*  75: 77 */     List<Resp_Cli> lista = new ArrayList();
/*  76: 78 */     while (rs.next())
/*  77:    */     {
/*  78: 79 */       Resp_Cli resp = new Resp_Cli();
/*  79: 80 */       resp.setCNPJCPF(rs.getString("CNPJCPF"));
/*  80: 81 */       resp.setRespVencidas(rs.getBigDecimal("RespVencidas"));
/*  81: 82 */       resp.setRespAVencer(rs.getBigDecimal("RespAVencer"));
/*  82: 83 */       resp.setStEI(rs.getInt("StEI"));
/*  83: 84 */       lista.add(resp);
/*  84:    */     }
/*  85: 86 */     stmt.close();
/*  86: 87 */     return lista;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void atualizar(Resp_Cli resp)
/*  90:    */     throws ClassNotFoundException, SQLException, Exception
/*  91:    */   {
/*  92: 94 */     String sql = "UPDATE Resp_Cli SET RespVencidas = ?, RespAVencer = ?, StEI = ? WHERE CNPJCPF = ?";
/*  93: 95 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  94: 96 */     stmt.setBigDecimal(1, resp.getRespVencidas());
/*  95: 97 */     stmt.setBigDecimal(2, resp.getRespAVencer());
/*  96: 98 */     stmt.setInt(3, resp.getStEI());
/*  97: 99 */     stmt.setString(4, resp.getCNPJCPF());
/*  98:100 */     stmt.executeQuery();
/*  99:101 */     stmt.close();
/* 100:    */   }
/* 101:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Resp_CliDAO
 * JD-Core Version:    0.7.0.1
 */