<%-- 
    Document   : display-all-users
    Created on : Apr 1, 2019, 3:08:05 AM
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

        <title>SB Admin - display all users</title>

        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">

        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">-->

        <link rel="stylesheet" href="resources/css/style.css">

    </head>

    <body id="page-top">

        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="admin.jsp">Electro<span>.</span></a>

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
                        <img src="resources/images/client.png" width="70px" height="70px" /></i>
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
                    <a class="nav-link" href="admin.jsp">
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
                        <a class="dropdown-item" href="add-category.jsp">Add Category</a>
                        <a class="dropdown-item" href="add-brand.jsp">Add Brand</a>
                        <a class="dropdown-item" href="add-product.jsp">Add Product</a>
                        <a class="dropdown-item" href="CreateProduct?action=updateProduct&recordsPerPage=10&currentPage=1">Update Product</a>
                        <a class="dropdown-item" href="CreateProduct?action=displayProduct&recordsPerPage=10&currentPage=1">Display All Product</a>

                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../client/createOrder?action=displayAllOrders&recordsPerPage=10&currentPage=1">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Orders</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="UserController?action=displayAllUsers&recordsPerPage=10&currentPage=1">
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
                        <li class="breadcrumb-item active">display all users</li>
                    </ol>

                    <div class="row col-sm-12">
                        <form style="width: 100%;" method="Get" action="UserSearch">
                            <div class="form-group" style="width: 100%">
                                <!--why required not working-->
                                <text style="font-size: 20px;">Search : </text><br/>
                                <input type="text" class="form-input" name="searchTxt" id="searchTxt"  value="${searchTxtValue}" placeholder="enter user name to search"/><br/><br>
                                <input type="text" class="form-input" name="phoneTxt" id="phoneTxt"  value="${phoneTxtValue}" placeholder="enter user phone to search"/>
                                <input type="hidden" class="form-input" name="currentPage" id="currentPage" value="1"/>
                                <input type="hidden" class="form-input" name="recordsPerPage" id="recordsPerPage" value="10" />
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" id="submit" class="form-submit" value="Search"/>
                            </div>
                        </form>
                    </div>
                    <div class="row col-md-12">

                        <table id="usersTable" class="table table-striped table-bordered table-sm" >
                            <tr>
                                <th>User Name</th>
                                <!--<th>Address</th>-->
                                <!--<th>Email</th>-->
                                <!--<th>Gender</th>-->
                                <!--<th>Birth Day</th>-->
                                <th>Phone</th>
                                <th>User Credit</th>
                                <th>User Wallet</th>
                                <th>User Image</th>
                            </tr>

                            <c:forEach items="${usersPagination}" var="current">
                                <tr data-toggle="modal" data-target="#userModal">
                                    <td>${current.name}</td>
                                    <td style="display: none;">${current.address}</td>
                                    <td style="display: none;">${current.email}</td>    
                                    <td style="display: none;">${current.gender}</td>    
                                    <td style="display: none;">${current.birthday}</td>    
                                    <td>${current.phone}</td>    
                                    <td>${current.userCredit.creditcard}</td>    
                                    <td>${current.userCredit.wallet}</td>    
                                    <td id="${current.picture}"><img src="../client/images/users_image/${current.picture}" style="width: 65px; height: 65px;" /></td>    
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <c:if test="${displayUsers == 'displayAllUsers'}">
                        <div class="row col-md-12">
                            <nav aria-label="Navigation for countries">
                                <ul class="pagination">
                                    <c:if test="${currentPage != 1}">
                                        <li class="page-item"><a class="page-link" 
                                                                 href="UserController?action=displayAllUsers&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
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
                                                                         href="UserController?action=displayAllUsers&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                    <c:if test="${currentPage lt noOfPages}">
                                        <li class="page-item"><a class="page-link" 
                                                                 href="UserController?action=displayAllUsers&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
                                        </li>
                                    </c:if>              
                                </ul>
                            </nav>
                        </div>

                    </c:if>


                    <c:if test="${displayUsers == 'displaySearchUsers'}">
                        <div class="row col-md-12">
                            <nav aria-label="Navigation for countries">
                                <ul class="pagination">
                                    <c:if test="${currentPage != 1}">
                                        <li class="page-item"><a class="page-link" 
                                                                 href="UserSearch?phoneTxt=${phoneTxtValue}&searchTxt=${searchTxtValue}&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
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
                                                                         href="UserSearch?phoneTxt=${phoneTxtValue}&searchTxt=${searchTxtValue}&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                    <c:if test="${currentPage lt noOfPages}">
                                        <li class="page-item"><a class="page-link" 
                                                                 href="UserSearch?phoneTxt=${phoneTxtValue}&searchTxt=${searchTxtValue}&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
                                        </li>
                                    </c:if>              
                                </ul>
                            </nav>
                        </div>

                    </c:if>

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



        <!-- Modal -->
        <div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div id="userDetails" class="modal-body">
                        <!-- write details here -->
                        
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <!--<button type="button" class="btn btn-primary">Save changes</button>-->
                    </div>
                </div>
            </div>
        </div>



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
        <script src="resources/vendor/jquery/jquery.min.js"></script>
        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="resources/vendor/datatables/jquery.dataTables.js"></script>
        <script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="resources/js/sb-admin.min.js"></script>

        <!-- Demo scripts for this page-->
        <script src="resources/js/demo/datatables-demo.js"></script>
        <script src="resources/js/displayAllUsers.js"></script>
        <!--<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>-->
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>-->
        <!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>-->

    </body>

</html>

