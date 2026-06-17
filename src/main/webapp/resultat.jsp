<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="co.kozao.calculatricescientifique.model.ResultatCalcul" %>

<%
    ResultatCalcul resultat = (ResultatCalcul) session.getAttribute("resultat");
    if (resultat != null) {
        session.removeAttribute("resultat");
%>
        <div class="resultat <%= resultat.isAErreur() ? "erreur" : "succes" %>">
            <% if (resultat.isAErreur()) { %>
                ⚠️ <%= resultat.getErreur() %>
            <% } else { %>
                ✅ Résultat : <%= resultat.getValeur() %>
            <% } %>
        </div>
<%
    }
%>