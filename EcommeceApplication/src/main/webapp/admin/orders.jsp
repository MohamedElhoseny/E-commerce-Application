<%-- 
    Document   : orders
    Created on : Apr 1, 2019, 4:02:24 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin - Dashboard</title>

        <!-- Custom fonts for this template-->
        <link href="../admin/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="../admin/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="../admin/resources/css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="../admin/resources/css/style.css">

    </head>

    <body id="page-top">

        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="../admin/admin.jsp">Electro<span>.</span></a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- admin name-->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <b class="form-control">${sessionScope.user.name}</b>
                </div>
                </div>
            </form>

            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0">

                <!-- admin image>-->
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="../admin/resources/images/client.png" width="70px" height="70px" /></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Update Profile</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
                    </div>
                </li>
            </ul>

        </nav>

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="../admin/admin.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Manage Products</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <a class="dropdown-item" href="../admin/add-category.jsp">Add Category</a>
                        <a class="dropdown-item" href="../admin/add-brand.jsp">Add Brand</a>
                        <a class="dropdown-item" href="../admin/add-product.jsp">Add Product</a>
                        <a class="dropdown-item" href="../admin/CreateProduct?action=updateProduct&recordsPerPage=10&currentPage=1">Update Product</a>
                        <a class="dropdown-item" href="../admin/CreateProduct?action=displayProduct&recordsPerPage=10&currentPage=1">Display All Product</a>

                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="createOrder?action=displayAllOrders&recordsPerPage=10&currentPage=1">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Orders</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../admin/UserController?action=displayAllUsers&recordsPerPage=10&currentPage=1">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Display All Users</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fas fa-fw fa-user"></i>
                        <span>add another admin</span></a>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- dashboard - overview links --> 

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Orders History</li>
                    </ol>

                    <div class="row col-sm-12">
                        <form style="width: 100%;" method="Get" action="OrderSearch">
                            <div class="form-group" style="width: 100%">
                                <!--why required not working-->
                                <text style="font-size: 20px;">Search by user's city : </text><br/><br>
                                <input type="text" class="form-input" name="orderSearchTxt" id="orderSearchTxt"  value="${searchTxtValue}" placeholder="enter user's City to search"/><br>
                                <input type="hidden" class="form-input" name="currentPage" id="currentPage" value="1"/>
                                <input type="hidden" class="form-input" name="recordsPerPage" id="recordsPerPage" value="10" />
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" id="submit" class="form-submit" value="Search"/>
                            </div>
                        </form>
                    </div>
                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            All Products</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <div class="row col-md-12">
                                    <table id="ordersTable" class="table table-striped table-bordered table-sm" >
                                        <tr>
                                            <th>Order Number</th>
                                            <th>User Name</th>
                                            <th>Address</th>
                                            <th>Post Code</th>
                                            <th>Total Price</th>
                                            <th>Buy Date</th>
                                        </tr>

                                        <c:forEach items="${ordersPagination}" var="current">
                                            <tr>
                                                <td>${current.id}</td>
                                                <td>${current.fullName}</td>
                                                <td>${current.country}, ${current.city}, ${current.street}</td>
                                                <td>${current.postcode}</td>    
                                                <td>${current.totalPrice}</td>    
                                                <td>${current.date}</td>

                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                <c:if test="${displayOrders == 'displayAllOrders'}">
                                    <div class="row col-md-12">
                                        <nav aria-label="Navigation for countries">
                                            <ul class="pagination">
                                                <c:if test="${currentPage != 1}">
                                                    <li class="page-item"><a class="page-link" 
                                                                             href="../client/createOrder?action=displayAllOrders&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
                                                    </li>
                                                </c:if>

                                                <c:forEach begin="1" end="${noOfPages}" var="i">
                                                    <c:choose>
                                                        <c:when test="${currentPage eq i}">
                                                            <li class="page-item active"><a class="page-link">
                                                                    ${i} <span class="sr-only">(current)</span></a>
                                                            </li>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <li class="page-item"><a class="page-link" 
                                                                                     href="../client/createOrder?action=displayAllOrders&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                                                            </li>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>

                                                <c:if test="${currentPage lt noOfPages}">
                                                    <li class="page-item"><a class="page-link" 
                                                                             href="../client/createOrder?action=displayAllOrders&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
                                                    </li>
                                                </c:if>              
                                            </ul>
                                        </nav>
                                    </div>
                                </c:if>




                                <c:if test="${displayOrders == 'displaySearchOrder'}">
                                    <div class="row col-md-12">
                                        <nav aria-label="Navigation for countries">
                                            <ul class="pagination">
                                                <c:if test="${currentPage != 1}">
                                                    <li class="page-item"><a class="page-link" 
                                                                             href="../client/OrderSearch?orderSearchTxt=${searchTxtValue}&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
                                                    </li>
                                                </c:if>

                                                <c:forEach begin="1" end="${noOfPages}" var="i">
                                                    <c:choose>
                                                        <c:when test="${currentPage eq i}">
                                                            <li class="page-item active"><a class="page-link">
                                                                    ${i} <span class="sr-only">(current)</span></a>
                                                            </li>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <li class="page-item"><a class="page-link" 
                                                                                     href="../client/OrderSearch?orderSearchTxt=${searchTxtValue}&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                                                            </li>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>

                                                <c:if test="${currentPage lt noOfPages}">
                                                    <li class="page-item"><a class="page-link" 
                                                                             href="../client/OrderSearch?orderSearchTxt=${searchTxtValue}&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
                                                    </li>
                                                </c:if>              
                                            </ul>
                                        </nav>
                                    </div>

                                </c:if>

                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <footer class="sticky-footer">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright © Your Website 2019</span>
                        </div>
                    </div>
                </footer>

            </div>
            <!-- /.content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="../client/SignoutServlet">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="../admin/resources/vendor/jquery/jquery.min.js"></script>
        <script src="../admin/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="../admin/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="../admin/resources/js/sb-admin.min.js"></script>
        <script src="../admin/resources/js/demo/datatables-demo.js"></script>

        <script src="../admin/resources/js/displayAllOrders.js"></script>

    </body>

</html>

