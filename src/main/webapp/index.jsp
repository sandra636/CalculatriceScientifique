<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculatrice Scientifique</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Calculatrice Scientifique</h1>

        <form action="calculer" method="post">

            <div class="form-group">
                <label for="nb1">Nombre 1 :</label>
                <input type="number" id="nb1" name="nb1" 
                       value="${nb1}" step="any" required/>
            </div>

            <div class="form-group">
                <label for="operation">Opération :</label>
                <select id="operation" name="operation">
                    <option value="addition">Addition (+)</option>
                    <option value="soustraction">Soustraction (-)</option>
                    <option value="multiplication">Multiplication (×)</option>
                    <option value="division">Division (÷)</option>
                    <option value="puissance">Puissance (aⁿ)</option>
                    <option value="racine">Racine carrée (√)</option>
                    <option value="factorielle">Factorielle (n!)</option>
                </select>
            </div>

            <div class="form-group">
                <label for="nb2">Nombre 2 :</label>
                <input type="number" id="nb2" name="nb2" 
                       value="${nb2}" step="any"/>
                <small style="color:#888;">Requis pour : +, -, ×, ÷, puissance</small>
            </div>

            <button type="submit">Calculer</button>

        </form>

        <%-- Affichage du résultat juste en dessous --%>
        <jsp:include page="resultat.jsp"/>

    </div>
</body>
</html>