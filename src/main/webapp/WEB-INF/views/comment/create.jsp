<%--
  Created by IntelliJ IDEA.
  User: kiril
  Date: 23.05.2021
  Time: 3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

    <title>Добавить комментарий</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="margin: 0 auto">
            <div class="card-header">
                <h4>Добавление комментария</h4>
            </div>
            <div class="card-body">
                <form class="form" action="<c:url value='/saveComment?id=${post.id}'/>" method='POST'>
                    <div class="form-group">
                        <h6>
                            <label for="content"> Комментарий: </label>
                        </h6>
                        <textarea class="input" rows="3" cols="50" id="content" name='desc'
                                  placeholder="Введите комментарий">
                        </textarea>
                    </div>
                    <div class="card-form" style="margin-top: 10px">
                        <button name="submit" type="submit" class="btn btn-primary floated">
                            Добавить
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>