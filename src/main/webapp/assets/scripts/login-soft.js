var Login = function() {

    var handleLogin = function() {
        $('.login-form').validate({
            errorElement : 'span', // default input error message container
            errorClass : 'help-block', // default input error message class
            focusInvalid : false, // do not focus the last invalid input
            rules : {
                username : {
                    required : true
                },
                password : {
                    required : true
                },
                remember : {
                    required : false
                }
            },

            messages : {
                username : {
                    required : "用户名不能为空."
                },
                password : {
                    required : "密码不能为空."
                }
            },

            invalidHandler : function(event, validator) { // display error
                // alert on form
                // submit
                $('.alert-danger', $('.login-form')).show();
            },

            highlight : function(element) { // hightlight error inputs
                $(element).closest('.form-group').addClass('has-error'); // set
                // error
                // class
                // to
                // the
                // control
                // group
            },

            success : function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement : function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler : function(form) {
                var passwordInput = $('[name="password"]');
                passwordInput.val(passwordInput.val());
                form.submit();
            }
        });

        $('.login-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.login-form').validate().form()) {
                    $('.login-form').submit();
                }
                return false;
            }
        });
    }

    var handleForgetPassword = function() {
        $('.forget-form').validate({
            errorElement : 'span', // default input error message container
            errorClass : 'help-block', // default input error message class
            focusInvalid : false, // do not focus the last invalid input
            ignore : "",
            rules : {
                newUsername : {
                    required : true
                },
                newPassword : {
                    required : true
                }
            },

            messages : {
                newUsername : {
                    required : "请填写用户名"
                },
                newPassword : {
                    required : "请填写新密码"
                }
            },

            invalidHandler : function(event, validator) { // display error
                // alert on form
                // submit

            },

            highlight : function(element) { // hightlight error inputs
                $(element).closest('.form-group').addClass('has-error'); // set
                // error
                // class
                // to
                // the
                // control
                // group
            },

            success : function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement : function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler : function(form) {
                form.submit();
            }
        });

        $('.forget-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.forget-form').validate().form()) {
                    $('.forget-form').submit();
                }
                return false;
            }
        });

        jQuery('#forget-password').click(function() {
            jQuery('.login-form').hide();
            jQuery('.forget-form').show();
        });

        jQuery('#back-btn').click(function() {
            jQuery('.login-form').show();
            jQuery('.forget-form').hide();
        });

    }

    var handleRegister = function() {

        function format(state) {

            if (!state.id)
                return state.text; // optgroup
            return state.text;
        }

        $("#select2_sample4")
                .select2(
                        {
                            placeholder : '<i class="fa fa-map-marker"></i>&nbsp;请选择所在部门',
                            allowClear : true,
                            formatResult : format,
                            formatSelection : format,
                            escapeMarkup : function(m) {
                                return m;
                            }
                        });

        $('#select2_sample4').change(function() {
            $('.register-form').validate().element($(this)); // revalidate
            // the chosen
            // dropdown
            // value and
            // show error or
            // success
            // message for
            // the input
        });

        $('.register-form').validate({
            errorElement : 'span', // default input error message container
            errorClass : 'help-block', // default input error message class
            focusInvalid : false, // do not focus the last invalid input
            ignore : "",
            rules : {
                departmentId : {
                    required : true
                },
                username : {
                    required : true
                },
                rpassword : {
                    required : true
                },
                r2password : {
                    equalTo : "#register_password"
                },
            },

            messages : { // custom messages for radio buttons and checkboxes
                departmentId : {
                    required : "请选择部门"
                },
                username : {
                    required : "请填写用户名"
                },
                rpassword : {
                    required : "请填写密码"
                },
                r2password : {
                    equalTo : "俩次密码不一致"
                },
            },

            invalidHandler : function(event, validator) { // display error
                // alert on form
                // submit

            },

            highlight : function(element) { // hightlight error inputs
                $(element).closest('.form-group').addClass('has-error'); // set
                // error
                // class
                // to
                // the
                // control
                // group
            },

            success : function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement : function(error, element) {
                if (element.attr("name") == "tnc") { // insert checkbox
                    // errors after the
                    // container
                    error.insertAfter($('#register_tnc_error'));
                } else if (element.closest('.input-icon').size() === 1) {
                    error.insertAfter(element.closest('.input-icon'));
                } else {
                    error.insertAfter(element);
                }
            },

            submitHandler : function(form) {
                form.submit();
            }
        });

        $('.register-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.register-form').validate().form()) {
                    $('.register-form').submit();
                }
                return false;
            }
        });

        jQuery('#register-btn').click(function() {
            jQuery('.login-form').hide();
            jQuery('.register-form').show();
        });

        jQuery('#register-back-btn').click(function() {
            jQuery('.login-form').show();
            jQuery('.register-form').hide();
        });
    }

    return {
        // main function to initiate the module
        init : function() {
            handleLogin();
            handleForgetPassword();
            handleRegister();

            $.backstretch([ "assets/img/bg/1.jpg", "assets/img/bg/2.jpg",
                    "assets/img/bg/3.jpg", "assets/img/bg/4.jpg" ], {
                fade : 1000,
                duration : 8000
            });
        }

    };

}();