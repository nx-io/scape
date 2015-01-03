<%@ page language="java" pageEncoding="UTF-8"
    contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="form_type" value="${item.id > 0 ? '编辑景观案例' : '新建景观案例'}"/>

<head>
    <title>${form_type} - 景观云图后台管理系统</title>

    <script src="resources/item/form.js"></script>
    <link rel="stylesheet" type="text/css" href="resources/libs/jquery/uploadify/uploadify.css" />
</head>

<!-- Bread line. -->
<section class="content-header">
    <h1>景观案例管理<small>${form_type}</small></h1>
    <ol class="breadcrumb">
        <li><a href="homePage"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li><a href="item/list"><i class="fa fa-user"></i> 景观案例管理</a></li>
        <li class="active">${form_type}</li>
    </ol>
</section>
<!-- Content. -->
<section class="content">
    <div class="row">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">${form_type}</h3>
            </div>
            <form role="form" autocomplete="off" action="${item.id > 0 ? 'item/edit' : 'item/add'}" method="POST">
                <input type="hidden" name="id" value="${item.id}" />
                <input type="hidden" name="type" value="${empty item.id ? 2 : item.type}" />
                <div class="box-body">
                    <div class="form-group">
                        <label>标题<span class="required-flag">*</span></label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-edit"></i>
                            </div>
                            <input name="title" type="text" class="form-control" id="title" value="${item.title}" placeholder="标题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>状态</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-shield"></i>
                            </div>
                            <select name="status" class="form-control">
                                <optgroup label="请选择状态">
                                    <option value="active" ${ 1 == item.status ? 'selected' : ''}>活动的</option>
                                    <option value="banned" ${ 0 == item.status ? 'selected' : ''}>冻结的</option>
                                </optgroup>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>分类</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-tag"></i>
                            </div>
                             <select name="category_id" class="form-control">
                                <optgroup label="请选择分类">
                                  <c:forEach items="${categories}" var="category">
                                    <option value="${category.id}" ${ category.id == item.category_id ? 'selected' : ''}>${category.name}</option>
                                  </c:forEach>
                                </optgroup>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>区域分类</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-tag"></i>
                            </div>
                             <select name="area_category_id" class="form-control">
                                <optgroup label="请选择区域分类">
                                  <c:forEach items="${areaCategories}" var="areaCategory">
                                    <option value="${areaCategory.id}" ${ areaCategory.id == item.area_category_id ? 'selected' : ''}>${areaCategory.name}</option>
                                  </c:forEach>
                                </optgroup>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>风格</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-tag"></i>
                            </div>
                             <select name="style_id" class="form-control">
                                <optgroup label="请选择风格">
                                  <c:forEach items="${styles}" var="style">
                                    <option value="${style.id}" ${ style.id == item.style_id ? 'selected' : ''}>${style.name}</option>
                                  </c:forEach>
                                </optgroup>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>设计师</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-edit"></i>
                            </div>
                            <input name="designer" type="text" class="form-control" id="designer" value="${item.designer}" placeholder="设计师">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>设计师联系方式</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-edit"></i>
                            </div>
                            <input name="designer_contact" type="text" class="form-control" id="designer_contact" value="${item.designer_contact}" placeholder="设计师联系方式">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>施工者</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-edit"></i>
                            </div>
                            <input name="constructor" type="text" class="form-control" id="constructor" value="${item.constructor}" placeholder="施工者">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>施工者联系方式</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-edit"></i>
                            </div>
                            <input name="constructor_contact" type="text" class="form-control" id="constructor_contact" value="${item.constructor_contact}" placeholder="施工者联系方式">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>封皮<span class="required-flag">*</span></label>
                        <div class="input-group">
                            <div id="cover-img" style="padding-bottom: 10px">
                                <input type="hidden" name="cover_media" value="${item.cover_media_path}">
                                <c:if test="${!empty item.cover_media}">
                                    <img style="height: 230px" src="${item.cover_media}" class="img-rounded"/>
                                </c:if>
                            </div>
	                        <div>
	                            <input type="file" class="select-image" id="select-icon">
	                        </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>描述<span class="required-flag">*</span></label>
                        <div class="textarea">
                            <textarea class="form-control" id="description" name="description" rows="4">${item.description}</textarea>
                        </div>
                    </div>
                </div>
                <div class="box-footer">
                    <div class="form-group">
                        <button type="submit" id="frm_submit" class="btn btn-primary">提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>