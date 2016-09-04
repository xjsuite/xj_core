<?xml version="1.0" encoding="UTF-8"?>

<%-- 
    Document   : home
    Created on : Aug 13, 2016, 6:30:28 AM
    Author     : anto89
--%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>

<s:layout-render name="/xj.core/layout/startbootstrap/FullLayout.jsp">
    <s:layout-component name="xj-content">

        <div class="container">

            <!-- Portfolio Item Heading -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Portfolio Item
                        <small>Item Subheading</small>
                    </h1>
                </div>
            </div>
            <!-- /.row -->

            <!-- Portfolio Item Row -->
            <div class="row">
                <div class="col-md-8">
                    <img class="img-responsive" src="http://placehold.it/750x500" alt="">
                </div>

                <div class="col-md-4">
                    <h3>Project Description</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae. Sed dui lorem, adipiscing in adipiscing et, interdum nec metus. Mauris ultricies, justo eu convallis placerat, felis enim.</p>
                    <h3>Project Details</h3>
                    <ul>
                        <li>Lorem Ipsum</li>
                        <li>Dolor Sit Amet</li>
                        <li>Consectetur</li>
                        <li>Adipiscing Elit</li>
                    </ul>
                </div>

            </div>
            <!-- /.row -->

            <!-- Related Projects Row -->
            <div class="row">

                <div class="col-lg-12">
                    <h3 class="page-header">Related Projects</h3>
                </div>

                <div class="col-sm-3 col-xs-6">
                    <a href="#">
                        <img class="img-responsive portfolio-item" src="http://placehold.it/500x300" alt="">
                    </a>
                </div>

                <div class="col-sm-3 col-xs-6">
                    <a href="#">
                        <img class="img-responsive portfolio-item" src="http://placehold.it/500x300" alt="">
                    </a>
                </div>

                <div class="col-sm-3 col-xs-6">
                    <a href="#">
                        <img class="img-responsive portfolio-item" src="http://placehold.it/500x300" alt="">
                    </a>
                </div>

                <div class="col-sm-3 col-xs-6">
                    <a href="#">
                        <img class="img-responsive portfolio-item" src="http://placehold.it/500x300" alt="">
                    </a>
                </div>

            </div>
            <!-- /.row -->
        </div>
    </s:layout-component>
</s:layout-render>

