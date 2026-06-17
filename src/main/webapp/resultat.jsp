<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="co.kozao.calculatricescientifique.model.ResultatCalcul" %>

<%
    ResultatCalcul resultat = (ResultatCalcul) request.getAttribute("resultat");
    if (resultat != null) {
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