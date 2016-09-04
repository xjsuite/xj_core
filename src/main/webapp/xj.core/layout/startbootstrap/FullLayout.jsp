<?xml version="1.0" encoding="UTF-8"?>

<%-- 
    Document   : FullLayout
    Created on : Jun 9, 2016, 7:51:52 AM
    Author     : Hendranto.Nugroho
--%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>

<s:layout-definition>
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
        "http://www.w3.org/TR/html4/loose.dtd">
    <html>
        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <meta name="description" content="Xj" />
            <s:layout-component name="xj-title">
                <title>Xj Application</title>
            </s:layout-component>
            <!-- Core CSS -->
            <link href="xj.core/layout/assets/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
            <link href="xj.core/layout/assets/css/font-awesome.min.css" rel='stylesheet' type='text/css' />
            <link href="xj.core/layout/assets/css/ionicons.min.css" rel='stylesheet' type='text/css' />

            <link href="xj.core/layout/assets/css/icon-font.min.css" rel="stylesheet" type='text/css' />
            <link href="xj.core/layout/assets/css/animate.css" rel="stylesheet" type='text/css' />
            <link href="xj.core/layout/assets/css/select2-bootstrap.min.css" rel="stylesheet" type='text/css' />
            <link href="xj.core/layout/assets/css/sweetalert.min.css" rel="stylesheet" type='text/css' />
            <link href="xj.core/layout/assets/css/datepicker3.min.css" rel="stylesheet" type='text/css' />
            <link href="xj.core/layout/assets/css/daterangepicker-bs3.min.css" rel="stylesheet" type='text/css' />            
            <link rel="shortcut icon" type="images/png" href="xj.core/layout/assets/images/xj_icon.png">
            <link href="xj.core/layout/assets/css/jquery-inpromptu/xj.min.css" rel="stylesheet" type="text/css"/>
            <link href="xj.core/builtin/css/xj.css" rel="stylesheet" type="text/css"/>

            <link href="xj.core/layout/startbootstrap/css/portfolio-item.css" rel="stylesheet" type="text/css"/>
            <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->

            <!--[if lt IE 9]>
            <script src="js/html5shiv.js"></script>
            <script src="js/respond.min.js"></script>
            <![endif]-->

            <s:layout-component name="xj-css"/>
        </head>
        <body>
            <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <s:layout-component name="xj-header">
                        <a class="navbar-brand" href="#">Xj Core</a>
                    </s:layout-component>

                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <s:layout-component name="xj-topmenu">
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="#">About</a>
                            </li>
                            <li>
                                <a href="#">Services</a>
                            </li>
                            <li>
                                <a href="#">Contact</a>
                            </li>
                        </ul>
                    </div>
                </s:layout-component>

                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>      


        <s:layout-component name="xj-content">

        </s:layout-component>

        <!-- Footer -->
        <div class="container">
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; Your Application Name</p>
                    </div>
                </div>
                <!-- /.row -->
            </footer>
        </div>

        <script src="xj.core/layout/assets/js/jquery-2.2.4.min.js"></script>
        <script src="xj.core/layout/assets/js/bootstrap.min.js"></script>
        <script src="xj.core/layout/assets/js/jquery-impromptu.min.js"></script>
        <script src="xj.core/layout/assets/js/jquery.validate.min.js"></script>
        <script src="xj.core/layout/assets/js/jquery.mask.min.js"></script>
        <script src="xj.core/layout/assets/js/jquery.scrollTo.min.js"></script>
        <script src="xj.core/layout/assets/js/additional-methods.min.js"></script>
        <script src="xj.core/layout/assets/js/modernizr.min.js"></script>
        <script src="xj.core/layout/assets/js/sweetalert.min.js"></script>
        <script src="xj.core/layout/assets/js/daterangepicker.min.js"></script>
        <script src="xj.core/layout/assets/js/bootstrap-datepicker.min.js"></script>
        <script src="xj.core/layout/adminlte-2.3.3/js/app.min.js"></script>
        <script src="xj.core/layout/assets/js/jquery.bootpag.min.js" type="text/javascript"></script>
        <s:layout-component name="xj-script"/>
    </body>
</html>
</s:layout-definition>
