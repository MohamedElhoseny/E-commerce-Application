<%-- 
    Document   : update-product
    Created on : Apr 1, 2019, 3:06:30 AM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin - update product</title>

        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="resources/css/style.css">
        <link rel="stylesheet" href="resources/css/messageStyle.css">

    </head>

    <body id="page-top">

        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="admin.jsp">Electro<span>.</span></a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <b class="form-control">${sessionScope.user.name}</b>
                </div>
                </div>
            </form>



            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0">

                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <!--<i class="fas fa-user-circle fa-fw">--><img src="resources/images/client.png" width="70px" height="70px" /></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Update Profile</a>
                        <!-- <a class="dropdown-item" href="#">Activity Log</a>-->
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
                        <li class="breadcrumb-item active">Update Product</li>
                    </ol>

                    <form style="width: 100%;" method="Get" action="UpdateProductSearch">
                        <div class="form-group" style="width: 100%">
                            <!--why required not working-->
                            <text style="font-size: 20px;">Search : </text><br/>
                            <input type="text" class="form-input" name="productSearchTxt" id="searchTxt"  value="${searchTxtValue}" placeholder="enter product name to search"/><br>
                            <input type="hidden" class="form-input" name="currentPage" id="currentPage" value="1"/>
                            <input type="hidden" class="form-input" name="recordsPerPage" id="recordsPerPage" value="10" />
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Search"/>
                        </div>
                    </form>

                    <section class="addproduct">
                        <form id="manageForm" method="POST" onsubmit="return testBrandIdProducts();" enctype="MULTIPART/FORM-DATA" action="CreateProduct?action=updateProduct">
                            <div class="container">
                                <h4> Update product<span style="font-size: 16px;"> select product which you want update from table below </span></h4>
                                <br>
                                <c:if test="${requestScope.operation == 'success'}">
                                    <div class="successAlert">
                                        <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span> 
                                        <strong>Success!</strong> Data Saved Successfully
                                    </div>

                                </c:if>
                                <c:if test="${requestScope.operation == 'oops error during save data please try again later'}">
                                    <div class="failAlert">
                                        <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span> 
                                        <strong>Fail!     </strong>${requestScope.operation}
                                    </div>

                                </c:if>
                                <div class="row">
                                    <table class="table">
                                        <tbody>
                                            <tr>
                                                <th scope="row">Product Brand</th>
                                                <td>
                                                    <select class="form-input" id="brandName" name="brandName" required>
                                                        <div id="chooseBrand" style="display: none;"></div>
                                                        <option value="" selected="true" disabled>Select Brand</option>
                                                        <c:forEach items="${brandList}" var="current">
                                                            <option value="${current.id}"><c:out value="${current.name}" /></option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                        <input type="hidden" id="brandID" name="brandID" />
                                        <input type="hidden" id="productID" name="productID" />
                                        <tr>
                                            <th scope="row">Product Name</th>
                                            <td><input type="text" id="productName" name="productName" class="form-control" placeholder="product Name" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Product Price</th>
                                            <td><input type="number" id="productPrice" name="productPrice" class="form-control" placeholder="product Price" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Product Discount (OPTIONAL)</th>
                                            <td> <input type="number" id="productDiscount" name="productDiscount" value="0" min="0" max="100" step="1"  placeholder="product Discount"/></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Processor</th>
                                            <td><input type="text" id="productProcessor" name="productProcessor" class="form-control" placeholder="product Processor"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">RAM (GB)</th>
                                            <td><input type="text" id="productRam" name="productRam" value="1" min="1" step="1"/></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Storage (GB)</th>
                                            <td><input type="text" id="productStorage" name="productStorage" value="16" min="1" step="1"/></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Operating system</th>
                                            <td><input type="text" id="productOS" name="productOS" class="form-control" placeholder="operating system"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Graphics card</th>
                                            <td><input type="text" id="productGraphicsCard" name="productGraphicsCard"  class="form-control" placeholder="product graphic card"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Description</th>
                                            <td><textarea id="productDescription" name="productDescription" class="form-control" placeholder="product Description"></textarea></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Quantity</th>
                                            <td><input type="number" id="productQuantity" name="productQuantity" class="form-control" placeholder="productQuantity" required></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Color</th>

                                            <td><select class="form-input" style="font-size:  16px;" id="productColor" name="productColor" required>
                                                    <option value="black"  selected="true"><c:out value="black" /></option>
                                                    <option value="red"><c:out value="red" /></option>
                                                    <option value="white"><c:out value="white" /></option>
                                                    <option value="blue"><c:out value="blue" /></option>
                                                    <option value="purple"><c:out value="purple" /></option>
                                                    <option value="pink"><c:out value="pink" /></option>
                                                    <option value="brown"><c:out value="brown" /></option>
                                                    <option value="green"><c:out value="green" /></option>
                                                    <option value="orange"><c:out value="orange" /></option>
                                                </select></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <br>

                                <div class="display-flex-center">
                                    <a type="button" class="btn btn-warning" >Update images </a>
                                    <button type="submit" style="margin-left: 10px;" class="btn btn-success" name="action" value="updateProduct">Update product</button>
                                    <button type="submit" id="deleteBtn" style="margin-left: 10px;" class="btn btn-success" name="action" value="deleteProduct">Delete product</button>
                                </div>
                                <br />

                                <div class="row col-sm-12">

                                </div>


                                <div class="table-responsive">

                                    <div class="row col-md-12">
                                        <table class="table table-striped table-bordered table-sm table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <tr>
                                                <th>Product Name</th>
                                                <th>Price</th>
                                                <th>Quantity</th>
                                                <th>Product Color</th>
                                                <th>Brand Name</th>
                                            </tr>

                                            <c:forEach items="${productPagination}" var="current">
                                                <tr>

                                                    <td style="display: none;" id="${current.pid}"></td>
                                                    <td><c:out value="${current.name}" /></td>
                                                    <td><c:out value="${current.price}" /></td>
                                                    <td><c:out value="${current.quantity}" /></td>
                                                    <td><c:out value="${current.productColor}" /></td>                                                    
                                                    <td><c:out value="${current.brand.name}" /></td>
                                                    <td style="display: none;" id="${current.brand.id}"></td>
                                                    <td style="display: none;" ><c:out value="${current.description}" /></td>

                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>

                                    <c:if test="${displayProducts == 'displayAllProducts'}">

                                        <div class="row col-md-12">
                                            <nav aria-label="Navigation for countries">
                                                <ul class="pagination">
                                                    <c:if test="${currentPage != 1}">
                                                        <li class="page-item"><a class="page-link" 
                                                                                 href="CreateProduct?action=updateProduct&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
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
                                                                                         href="CreateProduct?action=updateProduct&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                                                                </li>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>

                                                    <c:if test="${currentPage lt noOfPages}">
                                                        <li class="page-item"><a class="page-link" 
                                                                                 href="CreateProduct?action=updateProduct&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
                                                        </li>
                                                    </c:if>              
                                                </ul>
                                            </nav>
                                        </div>
                                    </c:if>


                                    <c:if test="${displayProducts == 'displaySearchProduct'}">
                                        <div class="row col-md-12">
                                            <nav aria-label="Navigation for countries">
                                                <ul class="pagination">
                                                    <c:if test="${currentPage != 1}">
                                                        <li class="page-item"><a class="page-link" 
                                                                                 href="UpdateProductSearch?productSearchTxt=${searchTxtValue}&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
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
                                                                                         href="UpdateProductSearch?productSearchTxt=${searchTxtValue}&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                                                                </li>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>

                                                    <c:if test="${currentPage lt noOfPages}">
                                                        <li class="page-item"><a class="page-link" 
                                                                                 href="UpdateProductSearch?productSearchTxt=${searchTxtValue}&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
                                                        </li>
                                                    </c:if>              
                                                </ul>
                                            </nav>
                                        </div>

                                    </c:if>
                                </div>

                            </div>
                        </form>
                    </section>
                </div>
            </div>
        </div>

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
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="resources/js/updateProductScript.js"></script>
</body>

</html>

