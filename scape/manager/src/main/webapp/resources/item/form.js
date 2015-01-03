require(["../require-config"], function() {
    require(['jquery', 'validate', 'uploadify'], function() {
        var basePath = $("#basePath").val();

        $('.select-image').uploadify({
            'removeTimeout': 1,
            'successTimeout': 300,
            'auto': true,
            'buttonText': 'Add Image',
            'fileSizeLimit': '5MB',
            'fileTypeDesc': 'Image File Types',
            'fileTypeExts': '*.gif; *.jpg; *.png; *.jpeg;',
            'width':'120',
            'height':'32',
            'multi': false,
            'swf': 'resources/libs/jquery/uploadify/uploadify.swf?ver=' + Math.random(),
            'uploader': basePath + '/image/upload',
            'onFallback': function() {
                console.log('Flash was not detected.');
            },
            'onUploadSuccess': function(file, data, response) {
                if (response && data) {
                    var imageInfo = JSON.parse(data),
                        strHtml = '';
                    if ('succeed' == imageInfo.status) {
                        strHtml += "<input type='hidden' name='cover_media' value=" + imageInfo.body.image_path + ">";
                        strHtml += "<img style='height: 230px' src='" + imageInfo.body.image_url + "' class='img-rounded'/>"
                        jQuery('#cover-img').html(strHtml);
                    } else {
                        if ('11000' == imageInfo.error_code) {
                            alert('上传失败');
                        }
                    }
                }
            }
        });

        $('form').validate({
            rules: {
                title: {
                    required: true,
                    minlength: 2,
                },
                article: {
                    required: true
                }
            },
            messages: {
                title: {
                    required: '标题不能为空',
                    minlength: "字符长度不能小于2个字符"
                },
                article: {
                    required: "内容不能为空"
                }
            },
            submitHandler: function(form) {
                form.submit();
            }
        });
    });
});