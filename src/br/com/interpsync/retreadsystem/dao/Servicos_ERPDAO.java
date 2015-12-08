/*   1:    */ package br.com.interpsync.retreadsystem.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Servicos_ERP;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ 
/*  14:    */ public class Servicos_ERPDAO
/*  15:    */ {
/*  16:    */   private Connection connection;
/*  17:    */   
/*  18:    */   public Servicos_ERPDAO()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 28 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  23:    */     }
/*  24:    */     catch (SQLException ex)
/*  25:    */     {
/*  26: 30 */       Logger.getLogger(Servicos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  27:    */     }
/*  28:    */     catch (ClassNotFoundException ex)
/*  29:    */     {
/*  30: 32 */       Logger.getLogger(Servicos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  31:    */     }
/*  32:    */     catch (Exception ex)
/*  33:    */     {
/*  34: 34 */       Logger.getLogger(Servicos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
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
/*  47:    */   public List<Servicos_ERP> listarTodos()
/*  48:    */     throws SQLException, ClassNotFoundException, Exception
/*  49:    */   {
/*  50: 52 */     String sql = "SELECT ALL * FROM SERVICOS_ERP";
/*  51: 53 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  52: 54 */     stmt.executeQuery();
/*  53: 55 */     ResultSet rs = stmt.getResultSet();
/*  54: 56 */     List<Servicos_ERP> servicos = new ArrayList();
/*  55: 57 */     while (rs.next())
/*  56:    */     {
/*  57: 58 */       Servicos_ERP servico = new Servicos_ERP();
/*  58: 59 */       servico.setCodSE(rs.getString("CodSE"));
/*  59: 60 */       servico.setDescrSE(rs.getString("DescrSE"));
/*  60: 61 */       servico.setValorSE(rs.getBigDecimal("ValorSE"));
/*  61: 62 */       servico.setStei(rs.getInt("Stei"));
/*  62: 63 */       servicos.add(servico);
/*  63:    */     }
/*  64: 65 */     stmt.close();
/*  65: 66 */     return servicos;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public List<Servicos_ERP> listarNovos()
/*  69:    */     throws SQLException, ClassNotFoundException, Exception
/*  70:    */   {
/*  71: 73 */     String sql = "SELECT * FROM SERVICOS_ERP WHERE StEI <> 1";
/*  72: 74 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  73: 75 */     stmt.executeQuery();
/*  74: 76 */     ResultSet rs = stmt.getResultSet();
/*  75: 77 */     List<Servicos_ERP> servicos = new ArrayList();
/*  76: 78 */     while (rs.next())
/*  77:    */     {
/*  78: 79 */       Servicos_ERP servico = new Servicos_ERP();
/*  79: 80 */       servico.setCodSE(rs.getString("CodSE"));
/*  80: 81 */       servico.setDescrSE(rs.getString("DescrSE"));
/*  81: 82 */       servico.setValorSE(rs.getBigDecimal("ValorSE"));
/*  82: 83 */       servico.setStei(rs.getInt("Stei"));
/*  83: 84 */       servicos.add(servico);
/*  84:    */     }
/*  85: 86 */     stmt.close();
/*  86: 87 */     return servicos;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void atualizar(Servicos_ERP servico)
/*  90:    */     throws ClassNotFoundException, Exception, SQLException
/*  91:    */   {
/*  92: 94 */     String sql = "UPDATE SERVICOS_ERP SET DescrSE = ?, ValorSE = ?, Stei = ? WHERE CodSE = ?";
/*  93: 95 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  94: 96 */     stmt.setString(1, servico.getDescrSE());
/*  95: 97 */     stmt.setBigDecimal(2, servico.getValorSE());
/*  96: 98 */     stmt.setInt(3, servico.getStei());
/*  97: 99 */     stmt.setString(4, servico.getCodSE());
/*  98:100 */     stmt.executeUpdate();
/*  99:101 */     stmt.close();
/* 100:    */   }
/* 101:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Servicos_ERPDAO
 * JD-Core Version:    0.7.0.1
 */