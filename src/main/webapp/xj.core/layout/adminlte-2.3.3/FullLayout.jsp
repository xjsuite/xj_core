<?xml version="1.0" encoding="UTF-8"?>

<%-- 
    Document   : SidebarLayout
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
            <link href="xj.core/layout/adminlte-2.3.3/css/AdminLTE.min.css" rel="stylesheet" type='text/css' />
            <link href="xj.core/layout/adminlte-2.3.3/css/skins/_all-skins.min.css" rel="stylesheet" type='text/css' />
            <link href="xj.core/layout/assets/css/select2-bootstrap.min.css" rel="stylesheet" type='text/css' />
            <link href="xj.core/layout/assets/css/sweetalert.min.css" rel="stylesheet" type='text/css' />
            <link href="xj.core/layout/assets/css/datepicker3.min.css" rel="stylesheet" type='text/css' />
            <link href="xj.core/layout/assets/css/daterangepicker-bs3.min.css" rel="stylesheet" type='text/css' />            
            <link rel="shortcut icon" type="images/png" href="xj.core/layout/assets/images/xj_icon.png">
            <link href="xj.core/layout/assets/css/jquery-inpromptu/xj.min.css" rel="stylesheet" type="text/css"/>
            <link href="xj.core/builtin/css/xj.css" rel="stylesheet" type="text/css"/>
            <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
            
            <!--[if lt IE 9]>
            <script src="js/html5shiv.js"></script>
            <script src="js/respond.min.js"></script>
            <![endif]-->

            <s:layout-component name="xj-css"/>
        </head>
        <body class="hold-transition skin-purple sidebar-mini">
            <div class="wrapper">
                <header class="main-header">
                    <!-- Logo -->
                    <a href="home.action" class="logo">                        
                        <span class="logo-mini"><b>X</b>j</span><!-- mini logo for sidebar mini 50x50 pixels -->                        
                        <span class="logo-lg"><b>Xj</b>Apps</span><!-- logo for regular state and mobile devices -->
                    </a>
                    <!-- Header Navbar: style can be found in header.less -->
                    <nav class="navbar navbar-static-top">

                        <div class="navbar-custom-menu">
                            <ul class="nav navbar-nav">
                                <!-- Messages: style can be found in dropdown.less-->
                                <li class="dropdown messages-menu">
                                    <s:layout-component name="xj-messages">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                            <i class="fa fa-envelope-o"></i>
                                            <span class="label label-success">1</span>
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li class="header">You have 1 messages</li>
                                            <li>
                                                <ul class="menu">
                                                    <li><!-- start message -->
                                                        <a href="#">
                                                            <div class="pull-left">
                                                                <img src="xj.core/layout/adminlte-2.3.3/img/developer.png" class="img-circle" alt="User Image">
                                                            </div>
                                                            <h4>
                                                                Support Team
                                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                                            </h4>
                                                            <p>Please overwrite message with layout component 'xj-message'</p>
                                                        </a>
                                                    </li>
                                                    <!-- end message -->                                                    
                                                </ul>
                                            </li>
                                            <li class="footer"><a href="#">See All Messages</a></li>
                                        </ul>
                                    </s:layout-component>
                                </li>

                                <!-- Notifications: style can be found in dropdown.less -->
                                <li class="dropdown notifications-menu">
                                    <s:layout-component name="xj-notifications">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                            <i class="fa fa-bell-o"></i>
                                            <span class="label label-warning">1</span>
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li class="header">You have 1 notification</li>
                                            <li>
                                                <!-- inner menu: contains the actual data -->
                                                <ul class="menu">
                                                    <li>
                                                        <a href="#">
                                                            <i class="fa fa-users text-aqua"></i> Please overwrite notification(s) with layout component 'xj-notfication'
                                                        </a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="footer"><a href="#">View all Notification</a></li>
                                        </ul>
                                    </s:layout-component>
                                </li>
                                <!-- Tasks: style can be found in dropdown.less -->
                                <li class="dropdown tasks-menu">
                                    <s:layout-component name="xj-tasks">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                            <i class="fa fa-flag-o"></i>
                                            <span class="label label-danger">1</span>
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li class="header">You have 9 tasks</li>
                                            <li>
                                                <!-- inner menu: contains the actual data -->
                                                <ul class="menu">
                                                    <li><!-- Task item -->
                                                        <a href="#">
                                                            <h3>
                                                                Overwrite with 'xj-tasks'
                                                                <small class="pull-right">20%</small>
                                                            </h3>
                                                            <div class="progress xs">
                                                                <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                                    <span class="sr-only">20% Complete</span>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </s:layout-component>
                                </li>

                                <!-- User Account: style can be found in dropdown.less -->
                                <li class="dropdown user user-menu">
                                    <s:layout-component name="xj-profile">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                            <img src="xj.core/layout/adminlte-2.3.3/img/developer.png" class="user-image" alt="User Image">
                                            <span class="hidden-xs">Guest</span>
                                        </a>   
                                        <ul class="dropdown-menu">
                                            <!-- User image -->
                                            <li class="user-header">
                                                <img src="xj.core/layout/adminlte-2.3.3/img/developer.png" class="img-circle" alt="User Image">

                                                <p>
                                                    Alexander Pierce - Web Developer
                                                    <small>Member since Nov. 2012</small>
                                                </p>
                                            </li>

                                            <!-- Menu Footer-->
                                            <li class="user-footer">
                                                <div class="pull-left">
                                                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                                                </div>
                                                <div class="pull-right">
                                                    <a href="#" class="btn btn-default btn-flat">Sign out</a>
                                                </div>
                                            </li>
                                        </ul>
                                    </s:layout-component>
                                </li>
                                <!-- Control Sidebar Toggle Button -->
                                <li>
                                    <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </header>  
           
                <!-- Content Wrapper. Contains page content -->
                <div class="content-wrapper" style="margin-left: 0px">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <s:layout-component name="xj-header">
                            <h1>
                                Change
                                <small>on 'xj-header'</small>
                            </h1>
                            <ol class="breadcrumb">
                                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                                <li class="active">Dashboard</li>
                            </ol>
                        </s:layout-component>
                    </section>
                    <section class="content">
                        <s:layout-component name="xj-content">

                        </s:layout-component>
                    </section>
                </div>
                <footer class="main-footer" style="margin-left: 0px">
                    <div class="pull-right hidden-xs">
                        <b>Version</b> 0.1
                    </div>
                    <strong>Copyright &copy; 2014-2015 <a href="http://xjapp.com">Your Application Name</a>.</strong> All rights
                    reserved.
                </footer>

                <!-- Developer and Administrator-->
                <aside class="control-sidebar control-sidebar-dark">
                    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
                        <li><a href="#control-sidebar-user-tab" data-toggle="tab"><i class="fa fa-user"></i></a></li>
                        <li><a href="#control-sidebar-code-tab" data-toggle="tab"><i class="fa fa-code"></i></a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane" id="control-sidebar-user-tab">
                            
                        </div>
                        <div class="tab-pane" id="control-sidebar-code-tab">
                            
                        </div>
                    </div>
                </aside>
                <div class="control-sidebar-bg"></div>
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
