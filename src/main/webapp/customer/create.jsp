<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create new customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Tạo khách hàng mới</h2>
    <a class="btn btn-info float-end" href="/customers">Danh sách khách hàng</a>
    <form method="post" action="/customers?action=create">
        <div class="mb-3">
            <label for="customerid" class="form-label">Mã khách hàng</label>
            <input type="text" class="form-control" id="customerid" name="id">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Tên khách hàng</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="text" class="form-control" id="email" name="email" >
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" id="address"name="address" >
        </div>
        <button type="submit" class="btn btn-primary">Tạo mới</button>
    </form>
</div>
</body>
</html>
